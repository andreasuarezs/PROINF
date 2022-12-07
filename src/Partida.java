import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Clase Partidad
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Partida {
	
	private Tablero tablero;
	private Banca banca;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Comunidad> listaComunidad;
	private ArrayList<Suerte> listaSuerte;
	
	/**
	 * Constructor por defecto
	 */
	public Partida()
	{
		tablero = new Tablero();
		banca = new Banca();
		jugadores = new ArrayList<Jugador>();
		listaComunidad = new ArrayList<Comunidad>();
		listaSuerte = new ArrayList<Suerte>();
	}
	
	/**
	 * Retorna el tablero del juego
	 * @return Tablero
	 */
	public Tablero getTablero() 
	{
		return tablero;
	}

	/**
	 * Retorna la banca del juego
	 * @return Banca
	 */
	public Banca getBanca() 
	{
		return banca;
	}
	
	public void menu()
	{
		int opcion;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println(".::MONOPOLY::.");
			System.out.println("1. Seleccionar cantidad jugadores");
			System.out.println("2. Empezar nueva partida");
			System.out.println("3. Cargar partida guardada");
			System.out.println("0. Salir");
			System.out.println("Selecciona una opcion (0-3): ");
			
			opcion = sc.nextInt();
			
			switch(opcion)
			{
				case 1:
					agregarJugadores();
					break;
				case 2:
					inicializar();
					jugar();
					break;
				case 3:
					//llamara a funcion que cargue partida desde archivo
					break;
				case 0:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Opcion invalida!");
					break;
			}
			
		}while(opcion != 0);
	}

	public void agregarJugadores()
	{
		int cantJugadores;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("Ingresa la cantidad de jugadores (2-8): ");
			cantJugadores = sc.nextInt();
			
			if(cantJugadores < 2 || cantJugadores > 8)
				System.out.println("Cantidad incorrecta! Debe ser entre 2 y 8!");
			
		}while(cantJugadores < 2 || cantJugadores > 8);
		
		for(int i = 0; i < cantJugadores; i++)
			jugadores.add(Jugador.nuevoJugador());
		
		Collections.shuffle(jugadores);
		System.out.println("Jugadores agregados!");
	}
	
	private void inicializar()
	{
		//Llenar las cartas de comunidad
		String ruta = System.getProperty("user.dir") + "\\" + "comunidad.txt";
		File archivo = new File(ruta);
		String linea;
		
		try
		{
			BufferedReader bfr = new BufferedReader(new FileReader(archivo));
			
			while((linea = bfr.readLine()) != null)
				listaComunidad.add(new Comunidad(linea));		
			
			Collections.shuffle(listaComunidad);
		}
		catch(IOException e)
		{
			System.out.println("Error cargando archivo cominitad.txt!");
		}
		
		//Llenar las cartas de suerte
		ruta = System.getProperty("user.dir") + "\\" + "suerte.txt";
		archivo = new File(ruta);
		
		try
		{
			BufferedReader bfr = new BufferedReader(new FileReader(archivo));
			
			while((linea = bfr.readLine()) != null)
				listaSuerte.add(new Suerte(linea));	
			
			Collections.shuffle(listaSuerte);
		}
		catch(IOException e)
		{
			System.out.println("Error cargando archivo suerte.txt!");
		}
		
		//Llenar las casillas del tablero
		ruta = System.getProperty("user.dir") + "\\" + "casillas.txt";
		archivo = new File(ruta);
		
		try
		{
			BufferedReader bfr = new BufferedReader(new FileReader(archivo));
			int cont = 1;
			
			while((linea = bfr.readLine()) != null)
			{
				//casillas unica
				if(cont == 1 || cont == 5 || cont == 11 || cont == 21 || cont == 31 || cont == 39)
				{
					Unica casillaUnica = new Unica(linea);
					tablero.getCasillas()[cont-1] = casillaUnica;
				}
				else if(cont == 3 || cont == 18 || cont == 34)  //comunidad
				{
					Comunidad casillaComunidad = new Comunidad(linea);
					tablero.getCasillas()[cont-1] = casillaComunidad;
				}
				else if(cont == 8 || cont == 23 || cont == 37)  //suerte
				{
					Suerte casillaSuerte = new Suerte(linea);
					tablero.getCasillas()[cont-1] = casillaSuerte;
				}
				else if(cont == 13 || cont == 29)  //casillas servicios
				{
					String[] data = linea.split(" "); 
					CompaniaPublica casillaCompania = new CompaniaPublica(data[0], Integer.parseInt(data[1]));
					tablero.getCasillas()[cont-1] = casillaCompania;
				}
				else if(cont == 6 || cont == 16 || cont == 26 || cont == 36) //casillas estaciones
				{
					String[] data = linea.split(" ");
					Estacion casillaEstacion = new Estacion(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));
					tablero.getCasillas()[cont-1] = casillaEstacion;
				}
				else //calles
				{
					String[] data = linea.split(" ");
					Calle casillaPropiedad = new Calle(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]));
					tablero.getCasillas()[cont-1] = casillaPropiedad;
				}
				
				cont++;
			}

			System.out.println("Partida inicializada...!");
		}
		catch(IOException e)
		{
			System.out.println("Error cargando archivo casillas.txt!");
		}
	}
	
	/**
	 * Metodo con la logica del juego
	 */
	private void jugar() 
	{
		System.out.println("\n\n:::INICIA EL JUEGO:::\n\n");	
		Scanner sc = new Scanner(System.in);
		
		int turno = 0;
		
		while(cantidadEnJuego() >= 2)
		{
			Jugador jugador = jugadores.get(turno);
			
			System.out.println("\n:::TURNO DEL JUGADOR " + jugador.getNombre() + ":::\n");
			System.out.println("Presiona enter para lanzar los dados...");
			sc.nextLine();
			
			//metodo de lanzar los dados
			jugador.lanzarDados();
			
			//verificar la casilla donde car el jugador
			int codigo = tablero.obtenerCasilla(jugador.getPosicion());
			
			/*
			 *  Leyenda de codigo:
			 *  
			 *  1 -> Propiedad que se puede comprar
			 *  2 -> Propiedad con duenyo
			 *  3 -> Tomar carta suerte
			 *  4 -> Tomar carta comunidad
			 *  5 -> Casilla especial
			 * */
			
			 if(codigo == 1) //Puede comprar la propiedad
			 {
				 Propiedad propiedad = (Propiedad) tablero.getCasillas()[jugador.getPosicion()];
				 
				 if(jugador.getDinero() >= propiedad.getPrecio()) //la compra
				 {
					 //Comprando la propiedad
					 jugador.setDinero(jugador.getDinero() - propiedad.getPrecio());
					 propiedad.setDuenyo(jugador);
					 tablero.getCasillas()[jugador.getPosicion()] = propiedad;
					 
					 System.out.println("\nEl jugador " + jugador.getNombre() +  " compra la propiedad " + propiedad.getNombre() + "\n");
				 }
				 else  //no tiene suficiente dinero
				 {
					 System.out.println("\nEl jugador " + jugador.getNombre() +  " no tiene para comprar la propiedad " + propiedad.getNombre() + "\n");
				 }
			 }
			 else if(codigo == 2)
			 {
				 Propiedad propiedad = (Propiedad) tablero.getCasillas()[jugador.getPosicion()];
				 
				 //verificamos el tipo de propiedad
				 if(propiedad instanceof Calle)
				 {
					 Calle calle = (Calle) propiedad;
					 int cobro = 0;
					 
					 switch(calle.getEstado())
					 {
						 case 0:
							 cobro = calle.getAlquiler();
						 case 1:
							 cobro = calle.getAlquiler1Casa();
						 case 2:
							 cobro = calle.getAlquiler2Casa();
						 case 3:
							 cobro = calle.getAlquiler3Casa();
						 case 4:
							 cobro = calle.getAlquiler4Casa();
						 case 5:
							 cobro = calle.getAlquilerHotel();
					 }
					 
					 //actualizamos montos de los jugadores
					 jugador.setDinero(jugador.getDinero() - cobro);
					 Jugador duenyo = propiedad.getDuenyo();
					 
					 //recorrer lista de jugadores y actualizar al que tenga el mismo nombre
					 
					 //AQUI - Verificar la posicion del jugador al moverse con los dados
					 
				 }
			 }
			
			//cambia turno
			if((turno + 1) < jugadores.size())
				turno++;
			else
				turno = 0;
		}
		
		//buscar ganador
		String ganador = "";
		for(int i = 0; i < jugadores.size(); i++)
			if(jugadores.get(i).getDinero() >= 0)
				ganador = jugadores.get(i).getNombre();
		
		System.out.println("\n\n:::FIN DEL JUEGO:::\n\n");
		System.out.println("\n\n:::GANADOR:::\n\n");
		System.out.println("\n\n:::" + ganador + ":::\n\n");
	}

	private int cantidadEnJuego() 
	{
		int cantidad = 0;
		
		for(int i = 0; i < jugadores.size(); i++)
			if(jugadores.get(i).getDinero() >= 0)
				cantidad++;
		
		return cantidad;
	}

	/**
	 * Metodo principal
	 * @param args Argumentos iniciales
	 */
	public static void main(String[] args)
	{
		Partida partida = new Partida();
		partida.menu();
	}
	
}
