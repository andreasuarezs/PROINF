package main;
/**
 * Clase Estacion
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Estacion extends Propiedad {

	private int alquiler1;  //valor a cobrar con una estacion
	private int alquiler2;  //valor a cobrar con dos estaciones
	private int alquiler3;  //valor a cobrar con tres estaciones
	private int alquiler4;  //valor a cobrar con cuatro estaciones
	
	/**
	 * Constructor por defecto
	 */
	public Estacion() 
	{
		this("", 0, 0, 0, 0, 0);
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre Nombre de la estacion
	 * @param precio Precio de la estacion
	 * @param alquiler1 Monto a pagar con 1 estacion
	 * @param alquiler2 Monto a pagar con 2 estaciones
	 * @param alquiler3 Monto a pagar con 3 estaciones
	 * @param alquiler4 Monto a pagar con 4 estaciones
	 */

	public Estacion(String nombre, int precio, int alquiler1, int alquiler2, int alquiler3, int alquiler4) 
	{
		super(nombre, precio);
		this.alquiler1 = alquiler1;
		this.alquiler2 = alquiler2;
		this.alquiler3 = alquiler3;
		this.alquiler4 = alquiler4;
	}

	/**
	 * Método que retorna el valor del alquiler
	 * @return Monto a pagar con 1 estacion
	 */
	public int getAlquiler1() 
	{
		return alquiler1;
	}
	
	/**
	 * Método que retorna el valor de dos alquileres
	 * @return Monto a pagar con 2 estaciones
	 */
	public int getAlquiler2() 
	{
		return alquiler2;
	}
	
	/**
	 * Método que retorna el valor de tres alquileres
	 * @return Monto a pagar con 3 estaciones
	 */
	public int getAlquiler3() 
	{
		return alquiler3;
	}

	/**
	 * Método que retorna el valor de cuatro alquileres
	 * @return Monto a pagar con 4 estaciones
	 */
	public int getAlquiler4() 
	{
		return alquiler4;
	}
	
	@Override
	/**
	 * Metodo que muestra la informacion de la estacion
	 */
	public String toString() 
	{
		return super.toString() + ", alquiler: " + alquiler1 + ", alquiler2: " 
	           + alquiler2 + ", alquiler3: " + alquiler3 + ", alquiler4: "
			   + alquiler4 + "]";
	}
	
}