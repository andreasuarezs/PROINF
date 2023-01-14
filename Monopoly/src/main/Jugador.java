package main;
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
	private int estaEnCarcel;      //0 -> no esta en carcel, 1-3 cantidad de turnos en carcel
	private boolean tieneCartaSalida;
	private int cantDobles;       //0-3 -> cantidad de dobles obtenidos consecutivamente
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
		this.estaEnCarcel = 0;
		this.tieneCartaSalida = false;
		this.cantDobles = 0;
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
	
	public int getEstaEnCarcel() 
	{
		return estaEnCarcel;
	}

	public void setEstaEnCarcel(int estaEnCarcel) 
	{
		this.estaEnCarcel = estaEnCarcel;
	}

	public boolean getTieneCartaSalida() 
	{
		return tieneCartaSalida;
	}

	public void setTieneCartaSalida(boolean tieneCartaSalida) 
	{
		this.tieneCartaSalida = tieneCartaSalida;
	}
	
	public int getCantDobles() 
	{
		return cantDobles;
	}
	public void setCantDobles(int cantDobles) 
	{
		this.cantDobles = cantDobles;
	}

	@Override
	/**
	 * Metodo que muestra la informacion del jugador
	 */
	public String toString() 
	{
		return "nombre: " + nombre + ", dinero: " + dinero + ", posicion: " + (posicion + 1);
	}
	
	public static Jugador nuevoJugador()
	{
		String nombre;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa el nombre del jugador: ");
		nombre = sc.nextLine();
		
		return new Jugador(nombre, CANTDINERO, 39);
	}
	
	public boolean lanzarDados(Tablero tablero)
	{
		boolean dobles = false;
		int dado1 = (int) Math.floor(Math.random() * 6) + 1;
		int dado2 = (int) Math.floor(Math.random() * 6) + 1;
		
		System.out.println("\nPrimer dado: " + dado1);
		System.out.println("Segundo dado: " + dado2 + "\n");
		
		if(dado1 == dado2)
		{
			System.out.println("\nHaz sacado dobles!!!\n");
			cantDobles++;
			dobles = true;
		}
		else
		{
			cantDobles = 0;
		}
		
		if(cantDobles == 3)
		{
			System.out.println("\nHaz sacado 3 veces consecutivas dobles. Ir a la carcel!!!\n");
			cantDobles = 0;
			posicion = 10; //la carcel
			
			if(tieneCartaSalida)
				tieneCartaSalida = false;
			else
				estaEnCarcel = 1;
		}
		else
		{
			int movimiento = dado1 + dado2;
			
			System.out.println("Avanza " + movimiento + " casillas\n");
			
			if((posicion + movimiento) <= 39)
			{
				posicion += movimiento;
			}
			else
			{
				posicion = (posicion + movimiento) - 39;
				
				if(tablero.hayCasillasLibres())
					dinero += 200;  //paso por salida y cobra 200
			}
		}
		
		return dobles;
	}
	
	public boolean lanzarDadosEnCarcel()
	{
		boolean dobles = false;
		int dado1 = (int) Math.floor(Math.random() * 6) + 1;
		int dado2 = (int) Math.floor(Math.random() * 6) + 1;
		
		System.out.println("\nPrimer dado: " + dado1);
		System.out.println("Segundo dado: " + dado2 + "\n");
		
		if(dado1 == dado2)
		{
			System.out.println("\nHaz sacado dobles - Sales libre de la carcel!!!\n");
			dobles = true;
		}
		else 
		{
			System.out.println("\nNO haz sacado dobles - Te quedas en la carcel!!!\n");
		}
		
		return dobles;
	}
	
}
