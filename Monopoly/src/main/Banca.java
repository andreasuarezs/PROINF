package main;
/**
 * Clase Banca
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Banca {
	
	private int dinero;
	private int cantCasas;
	private int cantHoteles;
	private static final int CANTCASA = 32;
	private static final int CANTHOTEL = 12;

	/**
	 * Constructor por defecto
	 */
	public Banca() 
	{
		this.dinero = 100000;  //inicializa en 100.000 la cantidad de dinero del banco
		this.cantCasas = CANTCASA;
		this.cantHoteles = CANTHOTEL;
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

	public int getCantCasas() 
	{
		return cantCasas;
	}
	
	public void setCantCasas(int cantCasas) 
	{
		this.cantCasas = cantCasas;
	}

	public int getCantHoteles() 
	{
		return cantHoteles;
	}

	public void setCantHoteles(int cantHoteles) 
	{
		this.cantHoteles = cantHoteles;
	}	

}
