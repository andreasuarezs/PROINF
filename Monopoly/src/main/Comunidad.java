package main;
import java.util.ArrayList;

/**
 * Clase Comunidad
 * @author Josep Molet y Andrea Suarez
 *
 */
public class Comunidad extends Especial {

	/**
	 * Contructor parametrizado
	 * @param descripcion La accion a realizar
	 */
	public Comunidad(String descripcion)
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
				jugador.setDinero(jugador.getDinero() + 200);
				break;
			case 3:
				jugador.setDinero(jugador.getDinero() - 50);
				break;
			case 4:
				jugador.setDinero(jugador.getDinero() + 50);
				break;
			case 5:
				jugador.setTieneCartaSalida(true);
				break;
			case 6:
				jugador.setPosicion(10);
					
				if(jugador.getTieneCartaSalida())
					jugador.setTieneCartaSalida(false);
				else
					jugador.setEstaEnCarcel(1);  //el jugador esta en la carcel
				break;
			case 7:
				int montoACobrar = (jugadores.size() - 1) * 50;
				
				jugador.setDinero(jugador.getDinero() + montoACobrar);
				
				//recorremos los demas jugadores y les restamos los 50
				for(int i = 0; i < jugadores.size(); i++)
					if(!jugadores.get(i).getNombre().equals(jugador.getNombre()))
						jugadores.get(i).setDinero(jugadores.get(i).getDinero() - 50);
				break;
			case 8:
				jugador.setDinero(jugador.getDinero() + 100);
				break;
			case 9:
				jugador.setDinero(jugador.getDinero() + 20);
				break;
			case 10:
				int montoCumpleanos = (jugadores.size() - 1) * 10;
				
				jugador.setDinero(jugador.getDinero() + montoCumpleanos);
				
				//recorremos los demas jugadores y les restamos los 10
				for(int i = 0; i < jugadores.size(); i++)
					if(!jugadores.get(i).getNombre().equals(jugador.getNombre()))
						jugadores.get(i).setDinero(jugadores.get(i).getDinero() - 10);
				break;
			case 11:
				jugador.setDinero(jugador.getDinero() + 100);
				break;
			case 12:
				jugador.setDinero(jugador.getDinero() - 100);
				break;
			case 13:
				jugador.setDinero(jugador.getDinero() - 150);
				break;
			case 14:
				int montoPagar = 0;
				
				for(int i = 0; i < tablero.getCasillas().length; i++)
				{
					if(tablero.getCasillas()[i] instanceof Calle)
					{
						Calle calle = (Calle) tablero.getCasillas()[i];
						
						if(calle.getDuenyo() != null && calle.getDuenyo().getNombre().equals(jugador.getNombre()))
						{
							if(calle.getEstado() >= 1 && calle.getEstado() <= 4)
								montoPagar += calle.getEstado() * 40;
							else if(calle.getEstado() == 5)
								montoPagar += 115;
						}
					}
				}
				
				//Actualizamos el dinero del jugador
				jugador.setDinero(jugador.getDinero() - montoPagar);
				break;
			case 15:
				jugador.setDinero(jugador.getDinero() + 10);
				break;
		}
		
		return jugador;
	}
	
}
