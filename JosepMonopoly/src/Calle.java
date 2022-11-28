/**
 * Clase Calle
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Calle extends Propiedad {

	private int costoCasa;      //costo de una casa en esta calle
	private int costoHotel;     //costo de un hotel en esta calle
	private int alquiler;       //valor a cobrar por alquiler
	private int alquiler1Casa;  //valor a cobrar con una casa
	private int alquiler2Casa;  //valor a cobrar con dos casas
	private int alquiler3Casa;  //valor a cobrar con tres casas
	private int alquiler4Casa;  //valor a cobrar con cuatro casas
	private int alquilerHotel;  //valor a cobrar con un hotel
	private int estado;         //indica si la calle posee alguna casa u hotel
	
	/**
	 * Constructor por defecto
	 */
	public Calle() 
	{
		this("", 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre Nombre de la calle
	 * @param precio Precio de compra de la calle
	 * @param costoCasa Costo de una casa en esta calle
	 * @param costoHotel Costo de un hotel en esta calle
	 * @param alquiler Valor de alquiler
	 * @param alquiler1Casa Valor con una casa
	 * @param alquiler2Casa Valor con dos casas
	 * @param alquiler3Casa Valor con tres casas
	 * @param alquiler4Casa Valor con cuatro casas
	 * @param alquilerHotel Valor con un hotel
	 */
	public Calle(String nombre, int precio, int costoCasa, int costoHotel, int alquiler, int alquiler1Casa, int alquiler2Casa, int alquiler3Casa,
			int alquiler4Casa, int alquilerHotel) 
	{
		super(nombre, precio);
		this.costoCasa = costoCasa;
		this.costoHotel = costoHotel;
		this.alquiler = alquiler;
		this.alquiler1Casa = alquiler1Casa;
		this.alquiler2Casa = alquiler2Casa;
		this.alquiler3Casa = alquiler3Casa;
		this.alquiler4Casa = alquiler4Casa;
		this.alquilerHotel = alquilerHotel;
		this.estado = 0;
	}

	/**
	 * Metodo que retorna el costo de una casa en esta calle
	 * @return El costo de colocar una casa
	 */
	public int getCostoCasa() 
	{
		return costoCasa;
	}

	/**
	 * Metodo que retorna el costo de un hotel en esta calle
	 * @return El costo de colocar un hotel
	 */
	public int getCostoHotel() 
	{
		return costoHotel;
	}

	/**
	 * Metodo que retorna el valor a pagar por alquiler
	 * @return El valor a pagar
	 */
	public int getAlquiler() 
	{
		return alquiler;
	}

	/**
	 * Metodo que retorna el valor a pagar por alquiler con una casa
	 * @return El valor a pagar con una casa
	 */
	public int getAlquiler1Casa() 
	{
		return alquiler1Casa;
	}

	/**
	 * Metodo que retorna el valor a pagar por alquiler con dos casas
	 * @return El valor a pagar con dos casas
	 */
	public int getAlquiler2Casa()
	{
		return alquiler2Casa;
	}

	/**
	 * Metodo que retorna el valor a pagar por alquiler con tres casas
	 * @return El valor a pagar con tres casas
	 */
	public int getAlquiler3Casa() 
	{
		return alquiler3Casa;
	}

	/**
	 * Metodo que retorna el valor a pagar por alquiler con cuatro casas
	 * @return El valor a pagar con cuatro casas
	 */
	public int getAlquiler4Casa() 
	{
		return alquiler4Casa;
	}

	/**
	 * Metodo que retorna el valor a pagar por alquiler con un hotel
	 * @return El valor a pagar con un hotel
	 */
	public int getAlquilerHotel() 
	{
		return alquilerHotel;
	}

	/**
	 * Metodo que retorna el estado de la calle (0-5)
	 * @return El estado de la calle
	 */
	public int getEstado() 
	{
		return estado;
	}

	/**
	 * Metodo que modifica el estado de la calle
	 * @param estado Nuevo estado de la calle (0-5)
	 */
	public void setEstado(int estado) 
	{
		this.estado = estado;
	}

	@Override
	/**
	 * Metodo que muestra la informacion de la calle
	 */
	public String toString() 
	{
		return super.toString() + ", costoCasa: " + costoCasa + ", costoHotel: " + costoHotel + 
				", alquiler: " + alquiler + ", alquiler1Casa: " + alquiler1Casa + 
				", alquiler2Casa: " + alquiler2Casa + ", alquiler3Casa: "
				+ alquiler3Casa + ", alquiler4Casa: " + alquiler4Casa + ", alquilerHotel: " 
				+ alquilerHotel + ", estado: " + estado + "]";
	}
}