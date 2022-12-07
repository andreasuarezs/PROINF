import java.util.Scanner;

/**
 * Clase Jugador
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Jugador {

	private int id;					
	private static int sigId = 1;   //atributo estatico que asigna el siguiente id al jugador
	private String nombre;
	private int dinero;
	private int posicion;
	private static final int CANTDINERO = 1500;
	
	/**
	 * Constructor por defecto
	 */
	public Jugador() 
	{
		this("", 0, 39);
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre Nombre del jugador
	 * @param dinero Cantidad de dinero que tiene el jugador
	 */
	public Jugador(String nombre, int dinero, int posicion) 
	{
		setId();
		this.nombre = nombre;
		this.dinero = dinero;
		this.posicion = posicion;
	}

	/**
	 * Metodo que retorna el id del jugador
	 * @return Id del jugador
	 */
	public int getId() 
	{
		return id;
	}
	
	/**
	 * Metodo que asigna el id del jugador
	 */
	private void setId() 
	{
		this.id = sigId;
		sigId++;
	}

	/**
	 * Metodo que retorna el nombre del jugador
	 * @return Nombre del jugador
	 */
	public String getNombre() 
	{
		return nombre;
	}

	/**
	 * Metodo que retorna la cantidad de dinero del jugador
	 * @return Cantidad de dinero
	 */
	public int getDinero() 
	{
		return dinero;
	}
	
	/**
	 * Metodo que actualiza la cantidad de dinero del jugador
	 * @param dinero Nueva cantidad de dinero
	 */
	public void setDinero(int dinero) 
	{
		this.dinero = dinero;
	}
	
	public int getPosicion() 
	{
		return posicion;
	}
	public void setPosicion(int posicion) 
	{
		this.posicion = posicion;
	}

	@Override
	/**
	 * Metodo que muestra la informacion del jugador
	 */
	public String toString() 
	{
		return "nombre: " + nombre + ", dinero: " + dinero;
	}
	
	public static Jugador nuevoJugador()
	{
		String nombre;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa el nombre del jugador: ");
		nombre = sc.nextLine();
		
		return new Jugador(nombre, CANTDINERO, 39);
	}
	
	public void lanzarDados()
	{
		int dado1 = (int) Math.floor(Math.random() * 6) + 1;
		int dado2 = (int) Math.floor(Math.random() * 6) + 1;
		
		System.out.println("\nPrimer dado: " + dado1);
		System.out.println("Segundo dado: " + dado2 + "\n");
		
		int movimiento = dado1 + dado2;
		
		System.out.println("Avanza " + movimiento + " casillas\n");
		
		if((posicion + movimiento) <= 39)
			posicion += movimiento;
		else
			posicion = (posicion + movimiento) - 40;
	}
}
