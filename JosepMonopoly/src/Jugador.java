
public class Jugador {

	private int id;
	private static int sigId = 1;
	private String nombre;
	private int dinero;
	
	public Jugador() 
	{
		this("", 0);
	}
	
	public Jugador(String nombre, int dinero) 
	{
		setId();
		this.nombre = nombre;
		this.dinero = dinero;
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
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public int getDinero() 
	{
		return dinero;
	}
	public void setDinero(int dinero) 
	{
		this.dinero = dinero;
	}

	@Override
	public String toString() 
	{
		return "id: " + id + ", nombre: " + nombre + ", dinero: " + dinero;
	}
}
