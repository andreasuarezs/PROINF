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
	
	public int obtenerCasilla(int pos)
	{
		/*
		 *  Leyenda de codigo:
		 *  
		 *  1 -> Propiedad que se puede comprar
		 *  2 -> Propiedad con duenyo
		 *  3 -> Tomar carta suerte
		 *  4 -> Tomar carta comunidad
		 *  5 -> Casilla especial
		 * */
		
		Casilla casilla = casillas[pos];
		
		if(casilla instanceof Propiedad)
		{
			Propiedad propiedad = (Propiedad) casilla;
			
			if(propiedad.getDuenyo() != null)
				return 2;
			else //no tiene duenyo
				return 1;
		}
		else if(casilla instanceof Suerte)
		{
			return 3;
		}
		else if(casilla instanceof Comunidad)
		{
			return 4;
		}
		else //casillas especiales
		{
			return 5;
		}
	}
	
}
