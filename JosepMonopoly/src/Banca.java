/**
 * Clase Banca
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Banca {
	
	private int dinero;

	/**
	 * Constructor por defecto
	 */
	public Banca() 
	{
		this.dinero = 100000;  //inicializa en 100.000 la cantidad de dinero del banco
	}

	/**
	 * Retorna la cantidad de dinero del banco
	 * @return Cantidad de dinero
	 */
	public int getDinero() 
	{
		return dinero;
	}
	
	/**
	 * Modifica la cantidad de dinero del banco
	 * @param dinero - Nueva cantidad
	 */
	public void setDinero(int dinero) 
	{
		this.dinero = dinero;
	}	
	
}