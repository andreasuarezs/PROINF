/**
 * Clase Especial
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Especial extends Casilla {

	private String descripcion;
	
	/**
	 * Constructor parametrizado
	 * @param descripcion La accion a realizar
	 */
	public Especial(String descripcion)
	{
		super();  //llamado al conrstructor del padre
		this.descripcion = descripcion;
	}

	/**
	 * Retorna la descripcion
	 * @return La descripcion
	 */
	public String getDescripcion() 
	{
		return descripcion;
	}

	@Override
	/**
	 * Muestra la informacion de la casilla especial
	 */
	public String toString() 
	{
		return "descripcion =" + descripcion;
	}
}
