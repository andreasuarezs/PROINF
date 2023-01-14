package main;
import java.util.ArrayList;

/**
 * Clase Suerte
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Suerte extends Especial {

	/**
	 * Constructor parameterizado
	 * @param descripcion La accion a realizar
	 */
	public Suerte(String descripcion)
	{
		super(descripcion);
	}

	public Jugador aplicarAccion(Jugador jugador, int numero, Tablero tablero, ArrayList<Jugador> jugadores)
	{
		switch(numero)
		{
			case 1:
				jugador.setPosicion(0);
				break;
			case 2:
				jugador.setPosicion(39);
				break;
			case 3:
				jugador.setPosicion(1);
				break;
			case 4:
				int posActualCom = jugador.getPosicion();
				
				if(posActualCom > 28 || posActualCom < 12)
					jugador.setPosicion(12);
				else
					jugador.setPosicion(28);
				break;
			case 5:
				int posActualEst = jugador.getPosicion();
				
				if(posActualEst < 5)
					jugador.setPosicion(5);
				else if(posActualEst < 15)
					jugador.setPosicion(15);
				else if(posActualEst < 25)
					jugador.setPosicion(25);
				else
					jugador.setPosicion(35);
				break;
			case 6:
				jugador.setDinero(jugador.getDinero() + 50);
				break;
			case 7:
				jugador.setTieneCartaSalida(true);
				break;
			case 8:
				jugador.setPosicion(jugador.getPosicion() - 3);
				break;
			case 9:
				jugador.setPosicion(10);
				
				if(jugador.getTieneCartaSalida())
					jugador.setTieneCartaSalida(false);
				else
					jugador.setEstaEnCarcel(1);  //el jugador esta en la carcel
				
				break;
			case 10:
				int montoPagar = 0;
				
				for(int i = 0; i < tablero.getCasillas().length; i++)
				{
					if(tablero.getCasillas()[i] instanceof Calle)
					{
						Calle calle = (Calle) tablero.getCasillas()[i];
						
						if(calle.getDuenyo() != null && calle.getDuenyo().getNombre().equals(jugador.getNombre()))
						{
							if(calle.getEstado() >= 1 && calle.getEstado() <= 4)
								montoPagar += calle.getEstado() * 25;
							else if(calle.getEstado() == 5)
								montoPagar += 100;
						}
					}
				}
				
				//Actualizamos el dinero del jugador
				jugador.setDinero(jugador.getDinero() - montoPagar);
				break;
			case 11:
				jugador.setDinero(jugador.getDinero() - 15);
				break;
			case 12:
				jugador.setPosicion(5);
				break;
			case 13:
				int montoACobrar = (jugadores.size() - 1) * 50;
				
				jugador.setDinero(jugador.getDinero() + montoACobrar);
				
				//recorremos los demas jugadores y les restamos los 50
				for(int i = 0; i < jugadores.size(); i++)
					if(!jugadores.get(i).getNombre().equals(jugador.getNombre()))
						jugadores.get(i).setDinero(jugadores.get(i).getDinero() - 50);
				break;
			case 14:
				jugador.setDinero(jugador.getDinero() + 150);
				break;
			case 15:
				jugador.setDinero(jugador.getDinero() + 100);
				break;
		}
		
		return jugador;
	}
}
