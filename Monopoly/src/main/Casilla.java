package main;
/**
 * Calse Casilla
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Casilla {

	private int numero;
	private static int sigNumero = 1;  //coloca el siguiente numero de casilla
	
	/**
	 * Constructor por defecto
	 */
	public Casilla() 
	{
		setNumero();
	}

	/**
	 * Retorna el numero de casilla
	 * @return numero casilla
	 */
	public int getNumero() 
	{
		return numero;
	}
	
	/**
	 * Asigna el siguiente numero a la casilla
	 */
	private void setNumero() 
	{
		this.numero = sigNumero;
		sigNumero++;
	}

}
