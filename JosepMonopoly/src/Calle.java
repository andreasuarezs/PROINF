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
	
	//AQUI
	
	

}
