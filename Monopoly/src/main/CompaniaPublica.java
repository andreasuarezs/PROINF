package main;
/**
 * Clase Companyia
 * @author Josep Molet y Andrea Suarez
 *
 */
public class CompaniaPublica extends Propiedad {

	/**
	 * Constructor por defecto
	 */
	public CompaniaPublica() 
	{
		this("", 0);
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre Nombre de la compania
	 * @param precio Precio de la compania
	 */
	public CompaniaPublica(String nombre, int precio) 
	{
		super(nombre, precio);
	}
	
}