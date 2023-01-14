package main;
/**
 * Clase Unica
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Unica extends Especial {

	/**
	 * Contructor parametrizado
	 * @param descripcion Nombre de la casilla
	 */
	public Unica(String descripcion)
	{
		super(descripcion);
	}
	
	public static Jugador aplicarAccion(Jugador jugador, Tablero tablero)
	{
		int casilla = jugador.getPosicion();
		
		switch(casilla)
		{
			case 0: 
				if(tablero.hayCasillasLibres())
					jugador.setDinero(jugador.getDinero() + 200);
				break;
			case 4:
				int pago = (int) (jugador.getDinero() * 0.1);
				jugador.setDinero(jugador.getDinero() - pago);
				tablero.setAcumuladoParking(tablero.getAcumuladoParking() + pago);
				break;
			case 10:
				//jugador de visita en la carcel
				break;
			case 20:
				jugador.setDinero(jugador.getDinero() + tablero.getAcumuladoParking());
				tablero.setAcumuladoParking(0);
				break;
			case 30:
				jugador.setPosicion(10);
				
				if(jugador.getTieneCartaSalida())
					jugador.setTieneCartaSalida(false);
				else
					jugador.setEstaEnCarcel(1);
				break;
			case 38:
				jugador.setDinero(jugador.getDinero() - 100);
				tablero.setAcumuladoParking(tablero.getAcumuladoParking() + 100);
				break;
		}
		
		return jugador;
	}
	
}
