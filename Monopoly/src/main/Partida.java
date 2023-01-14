package main;
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
					//TODO: llamara a funcion que cargue partida desde archivo
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
			boolean dobles = false;
			
			if(jugador.getDinero() >= 0) //validando que sea un jugador que no ha perdido
			{
				if(jugador.getEstaEnCarcel() == 0) //jugador libre
				{
					System.out.println("\n:::TURNO DEL JUGADOR " + jugador.getNombre() + ":::\n");
					System.out.println("Presiona enter para lanzar los dados...");
					sc.nextLine();
					
					//metodo de lanzar los dados
					dobles = jugador.lanzarDados(tablero);
					
					moverJugador(jugador, turno);
				}
				else //jugador en carcel
				{
					if(jugador.lanzarDadosEnCarcel())
					{
						//sale libre
						jugador.setEstaEnCarcel(0);  //se coloca libre
						
						//el jugador hace su lanzamiento
						System.out.println("\n:::TURNO DEL JUGADOR " + jugador.getNombre() + ":::\n");
						System.out.println("Presiona enter para lanzar los dados...");
						sc.nextLine();
						
						//metodo de lanzar los dados
						dobles = jugador.lanzarDados(tablero);
						
						moverJugador(jugador, turno);
					}
					else
					{
						//queda en la carcel
						if(jugador.getEstaEnCarcel() == 3)
						{
							jugador.setDinero(jugador.getDinero() - 50);  //se cobra la deuda
							jugador.setEstaEnCarcel(0); //queda libre
						}
						else
						{
							jugador.setEstaEnCarcel(jugador.getEstaEnCarcel() + 1); //auemntamos turnos en la carcel
						}
					}
				}
			}
			
			//cambia turno si no saco dobles
			if(!dobles)
			{
				if((turno + 1) < jugadores.size())
					turno++;
				else
					turno = 0;
			}
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

	private void moverJugador(Jugador jugador, int turno) 
	{
		//verificar la casilla donde cae el jugador
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
		 else if(codigo == 2) //debe pagar al duenyo
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
				 
				 if(jugador.getDinero() >= cobro) //juagdor tiene el dinero para pagar
				 {
					 jugador.setDinero(jugador.getDinero() - cobro);
					 Jugador duenyo = propiedad.getDuenyo();
					 
					 //recorrer lista de jugadores y actualizar al que tenga el mismo nombre
					 
					 for(int i = 0; i < jugadores.size(); i++)
						 if(jugadores.get(i).getNombre().equals(duenyo.getNombre()))
							 jugadores.get(i).setDinero(jugadores.get(i).getDinero() + cobro);
					 
					 System.out.println("El jugador " + jugador.getNombre() + " le toca pagar " + cobro + " al jugador " + duenyo.getNombre());
				 }
				 else //no tiene suficiente dinero para pagar
				 {
					 Jugador duenyo = propiedad.getDuenyo();
					 
					 //recorrer lista de jugadores y actualizar al que tenga el mismo nombre
					 for(int i = 0; i < jugadores.size(); i++)
						 if(jugadores.get(i).getNombre().equals(duenyo.getNombre()))
							 jugadores.get(i).setDinero(jugadores.get(i).getDinero() + jugador.getDinero());
					 
					 System.out.println("El jugador " + jugador.getNombre() + " le toca pagar " + jugador.getDinero() + " al jugador " + duenyo.getNombre());
				 
					 int cantidadFaltante = cobro - jugador.getDinero();  //se calcula el monto que falta por pagar
					 jugador.setDinero(0);  //se coloca en cero al jugador
					 
					 //AQUI - buscar propiedades para pagar con ellas hasta saldar la deuda o quedar en bancarrota.
				 }
			 }
			 else if(propiedad instanceof Estacion)
			 {
				 Estacion estacion = (Estacion) propiedad;
				 Jugador duenyo = estacion.getDuenyo();
				 
				 int cantidadEstaciones = 0;
				 
				 //recorremos las cuatro estaciones 
				 for(int i = 5; i <= 35; i += 10)
				 {
					 Estacion est = (Estacion) tablero.getCasillas()[i];
					 
					 if(est.getDuenyo() != null && est.getDuenyo().getNombre().equals(duenyo.getNombre()))
						 cantidadEstaciones++;
				 }
				 
				 int cobro = 0;
				 
				 switch(cantidadEstaciones)
				 {
				 	case 1:
				 		cobro = estacion.getAlquiler1();
				 		break;
				 	case 2:
				 		cobro = estacion.getAlquiler2();
				 		break;
				 	case 3:
				 		cobro = estacion.getAlquiler3();
				 		break;
				 	case 4:
				 		cobro = estacion.getAlquiler4();
				 		break;
				 }
		
				 //actualizamos montos de los jugadores
				 
				 //TODO: Validar que ocurre si no tiene dinero y debe pagar con propiedades
				 
				 jugador.setDinero(jugador.getDinero() - cobro);
				 
				 //recorrer lista de jugadores y actualizar al que tenga el mismo nombre
				 
				 for(int i = 0; i < jugadores.size(); i++)
					 if(jugadores.get(i).getNombre().equals(duenyo.getNombre()))
						 jugadores.get(i).setDinero(jugadores.get(i).getDinero() + cobro);
			 
				 System.out.println("El jugador " + jugador.getNombre() + " le toca pagar " + cobro + " al jugador " + duenyo.getNombre());
			 }
			 else //Compania publica
			 {
				 CompaniaPublica compania = (CompaniaPublica) propiedad;
				 Jugador duenyo = compania.getDuenyo();
				 
				 int cantidadCompanias = 0;
				 
				 //recorremos las dos compania 
				 CompaniaPublica compania1 = (CompaniaPublica) tablero.getCasillas()[12];
				 CompaniaPublica compania2 = (CompaniaPublica) tablero.getCasillas()[28];
				 
				 if(compania1.getDuenyo().getNombre().equals(duenyo.getNombre()))
					 cantidadCompanias++;
				 
				 if(compania2.getDuenyo().getNombre().equals(duenyo.getNombre()))
					 cantidadCompanias++;
				 
				 int multiplo = 1;

				 switch(cantidadCompanias)
				 {
				 	case 1:
				 		multiplo = 4;
				 		break;
				 	case 2:
				 		multiplo = 10;
				 		break;
				 }
				 
				 //lanzar dados para calcular pago
				 int dado1 = (int) Math.floor(Math.random() * 6) + 1;
				 int dado2 = (int) Math.floor(Math.random() * 6) + 1;
				 
				 int totalDados = dado1 + dado2;
				 int cobro = totalDados * multiplo;
		
				 //actualizamos montos de los jugadores
				 
				 //TODO: Validar que ocurre si no tiene dinero y debe pagar con propiedades
				 
				 jugador.setDinero(jugador.getDinero() - cobro);
				 
				 //recorrer lista de jugadores y actualizar al que tenga el mismo nombre
				 
				 for(int i = 0; i < jugadores.size(); i++)
					 if(jugadores.get(i).getNombre().equals(duenyo.getNombre()))
						 jugadores.get(i).setDinero(jugadores.get(i).getDinero() + cobro);
			 
				 System.out.println("El jugador " + jugador.getNombre() + " lanza los dados y saco: " + totalDados);
				 System.out.println("Le toca pagar " + cobro + " al jugador " + duenyo.getNombre());
			 }
		 }
		 else if(codigo == 3) //casilla de suerte
		 {
			 Suerte carta = listaSuerte.remove(0);  //se saca la primera carta
			 String[] descripcion = carta.getDescripcion().split("-");
			 int numero = Integer.parseInt(descripcion[0]);
			 String texto = descripcion[1];
			 
			 System.out.println("El jugador " + jugador.getNombre() + " saca la siguiente carta: " + texto);
			 
			 //aplicamos accion de la carta
			 jugador = carta.aplicarAccion(jugador, numero, tablero, jugadores);
			 
			 //verifica si la accion requiere un movimento del jugador
			 if(numero == 1 || numero == 2 || numero == 3 || numero == 4 || numero == 5 ||
				numero == 8 || numero == 9 || numero == 12)
			 {
				 moverJugador(jugador, turno);
			 }
			 
			 //metemos la carta al final
			 if(numero != 7)  //carta de salida de la carcel
				 listaSuerte.add(carta);
		 }
		 else if(codigo == 4) // carta comunidad
		 {
			 Comunidad carta = listaComunidad.remove(0);  //se saca la primera carta
			 String[] descripcion = carta.getDescripcion().split("-");
			 int numero = Integer.parseInt(descripcion[0]);
			 String texto = descripcion[1];
			 
			 System.out.println("El jugador " + jugador.getNombre() + " saca la siguiente carta: " + texto);
			 
			 //aplicamos accion de la carta
			 jugador = carta.aplicarAccion(jugador, numero, tablero, jugadores);
			 
			 //verifica si la accion requiere un movimento del jugador
			 if(numero == 1 || numero == 6)
			 {
				 moverJugador(jugador, turno);
			 }
			 
			 //metemos la carta al final
			 if(numero != 5)  //carta de salida de la carcel
				 listaComunidad.add(carta);
		 }
		 else //casillas unicas
		 {
			 jugador = Unica.aplicarAccion(jugador, tablero);
		 }
		
		 //actualizar el jugador en turno dentro de la lista de jugadores
		 jugadores.set(turno, jugador);
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
