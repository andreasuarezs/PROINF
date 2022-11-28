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
					//jugar();
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
		
		//Llenar el tablero con las casillas
		tablero.getCasillas()[0] = new Especial("salida");
		
		//AQUI - llenar tablero con las casillas correspondientes
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