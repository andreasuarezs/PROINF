/**
 * Clase Propiedad
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Propiedad {

	private int id;
	private static int sigId = 1; //atributo estatico que asigna el siguiente id a la propiedad
	private String nombre;
	private Jugador duenyo;
	private int precio;
	
	/**
	 * Constructor por defecto
	 */
	public Propiedad()
	{
		this("", 0);
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre Nombre de la propiedad
	 * @param precio El precio de la propiedad
	 */
	public Propiedad(String nombre, int precio)
	{
		setId();
		this.nombre = nombre;
		this.precio = precio;
		this.duenyo = null;
	}
	
	/**
	 * Metodo que retorna el id de la propiedad
	 * @return Id de la propiedad
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Metodo que asigna el id de la propiedad
	 */
	private void setId()
	{
		this.id = sigId;
		sigId++;
	}
	
	/**
	 * Metodo que retorna el nombre de la propiedad
	 * @return Nombre de la propiedad
	 */
	public String getNombre()
	{
		return nombre;
	}
	
	/**
	 * Metodo que retorna el precio de la propiedad
	 * @return El precio de la propiedad
	 */
	public int getPrecio()
	{
		return precio;
	}
	
	/**
	 * Metodo que retorna el jugador que es duenyo de la propiedad
	 * @return Jugador duenyo
	 */
	public Jugador getDuenyo() 
	{
		return duenyo;
	}
	
	/**
	 * Metodo que modifica el duenyo de la propiedad
	 * @param duenyo El nuevo duenyo
	 */
	public void setDuenyo(Jugador duenyo) 
	{
		this.duenyo = duenyo;
	}

	@Override
	/**
	 * Metodo que muestra la informacion de la propiedad
	 */
	public String toString()
	{
		return "nombre: " + nombre + ", precio: " + precio;
	}
}
