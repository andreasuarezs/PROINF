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
	
	/**
	 * Constructor por defecto
	 */
	public Jugador() 
	{
		this("", 0);
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre Nombre del jugador
	 * @param dinero Cantidad de dinero que tiene el jugador
	 */
	public Jugador(String nombre, int dinero) 
	{
		setId();
		this.nombre = nombre;
		this.dinero = dinero;
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

	@Override
	/**
	 * Metodo que muestra la informacion del jugador
	 */
	public String toString() 
	{
		return "nombre: " + nombre + ", dinero: " + dinero;
	}
}
