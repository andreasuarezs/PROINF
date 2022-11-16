/**
 * Clase Tablero
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Tablero {

	private Casilla[] casillas;
	
	/**
	 * Constructor por defecto
	 */
	public Tablero()
	{
		casillas = new Casilla[40];
	}
	
	/**
	 * Retorna el array de casillas
	 * @return Las casillas
	 */
	public Casilla[] getCasillas() 
	{
		return casillas;
	}
	
}
