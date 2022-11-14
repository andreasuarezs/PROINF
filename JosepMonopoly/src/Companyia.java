/**
 * Clase Companyia
 * @author Josep Molet y Andrea Suarez
 *
 */

public class Companyia extends Propiedad {
	private int unaCompanyia;
	private int dosCompanyias;
	private int hipoteca;
	private int estado;
	
	/**
	 * Constructor por defecto
	 */
	public Companyia() 
	{
		this("", 0, 0, 0, 0);
	}
	
	/**
	 * Constructor parametrizado
	 * @param nombre
	 * @param precio
	 * @param unacompanyia
	 * @param doscompanyias
	 * @param hipoteca
	 */
	public Companyia(String nombre, int precio, int unaCompanyia, int dosCompanyias, int hipoteca) 
	{
		super(nombre, precio);
		this.unaCompanyia = unaCompanyia;
		this.dosCompanyias = dosCompanyias;
		this.hipoteca = hipoteca;
		this.estado = 0;
	}

	public int getUnaCompanyia() {
		return unaCompanyia;
	}

	public int getDosCompanyias() {
		return dosCompanyias;
	}


	public int getHipoteca() {
		return hipoteca;
	}


	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@Override
	/**
	 * Metodo que muestra la informacion de la compañia
	 */
	public String toString() 
	{
		return super.toString() + ", unaCompanyia: " + unaCompanyia + ", dosCompanyias: " + dosCompanyias + 
				", hipoteca: " + hipoteca + ", estado: " + estado + "]";
	}
	
}