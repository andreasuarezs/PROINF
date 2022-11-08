
public class Propiedad {

	private int id;
	private static int sigId = 1;
	private String nombre;
	private Jugador duenyo;
	private int precio;
	
	public Propiedad()
	{
		this("", 0);
	}
	
	public Propiedad(String nombre, int precio)
	{
		setId();
		this.nombre = nombre;
		this.precio = precio;
		this.duenyo = null;
	}
	
	public int getId()
	{
		return id;
	}
	private void setId()
	{
		this.id = sigId;
		sigId++;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public int getPrecio()
	{
		return precio;
	}
	
	public Jugador getDuenyo() 
	{
		return duenyo;
	}
	public void setDuenyo(Jugador duenyo) 
	{
		this.duenyo = duenyo;
	}

	@Override
	public String toString()
	{
		return "nombre: " + nombre + ", precio: " + precio;
	}
}
