/**
 * Clase Calle
 * @author Josep Molet y Andrea Suarez
 *
 */

public class Estacion extends Propiedad {

	private int alquiler1;  //valor a cobrar con una estacion
	private int alquiler2;  //valor a cobrar con dos estaciones
	private int alquiler3;  //valor a cobrar con tres estaciones
	private int alquiler4;  //valor a cobrar con cuatro estaciones
	private int hipoteca;	//valor a cobrar con hipoteca
	private int estado;     //indica si posee mas de una estacion
	
	/**
	 * Constructor por defecto
	 */
	
	public Estacion() 
	{
		this("", 0, 0, 0, 0, 0, 0);
	}
	
	/**
	 * 
	 * @param nombre
	 * @param precio
	 * @param alquiler1
	 * @param alquiler2
	 * @param alquiler3
	 * @param alquiler4
	 * @param hipoteca
	 */

	public Estacion(String nombre, int precio, int alquiler1, int alquiler2, int alquiler3, int alquiler4, int hipoteca) 
	{
		super(nombre, precio);
		this.alquiler1 = alquiler1;
		this.alquiler2 = alquiler2;
		this.alquiler3 = alquiler3;
		this.alquiler4 = alquiler4;
		this.hipoteca = hipoteca;
		this.estado = 0;
	}

	/**
	 * Método que retorna el valor del alquiler
	 * @return
	 */
	
	public int getAlquiler1() {
		return alquiler1;
	}
	
	/**
	 * Método que retorna el valor de dos alquileres
	 * @return
	 */

	public int getAlquiler2() {
		return alquiler2;
	}
	
	/**
	 * Método que retorna el valor de tres alquileres
	 * @return
	 */
	public int getAlquiler3() {
		return alquiler3;
	}

	/**
	 * Método que retorna el valor de cuatro alquileres
	 * @return
	 */
	
	public int getAlquiler4() {
		return alquiler4;
	}
	
	/**
	 * Método que retorna el valor de la hipoteca
	 * @return
	 */
	
	public int getHipoteca() {
		return hipoteca;
	}
	
	/**
	 * Método que retorna el estado de la estacion
	 * @return
	 */
	
	public int getEstado() 
	{
		return estado;
	}

	/**
	 * Método que modifica el estado de la estacion
	 * @param estado
	 */
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@Override
	/**
	 * Metodo que muestra la informacion de la estacion
	 */
	
	public String toString() 
	{
		return super.toString() + ", alquiler: " + alquiler1 + ", alquiler2: " + alquiler2 + 
				", alquiler3: " + alquiler3 + ", alquiler4: "
				+ alquiler4 + ", hipoteca: " + hipoteca + ", estado: " + estado + "]";
	}
	
}
	
	
	