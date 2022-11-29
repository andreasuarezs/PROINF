import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	
	private void barajear(ArrayList<Especial> cartas)
	{
		//AQUI
	}
	
	/**
	 * Metodo con la logica del juego
	 */
	private void jugar() 
	{
		System.out.println("\n\n:::INICIA EL JUEGO:::\n\n");		
		
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
