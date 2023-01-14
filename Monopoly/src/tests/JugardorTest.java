package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import main.Jugador;

class JugardorTest {

	@Test
	public void constructorDefecto() 
	{
		Jugador jugador = new Jugador();
		
		assertEquals("", jugador.getNombre());
		assertEquals(0, jugador.getDinero());
		assertEquals(39, jugador.getPosicion());
		assertEquals(0, jugador.getEstaEnCarcel());
		assertEquals(false, jugador.getTieneCartaSalida());
		assertEquals(0, jugador.getCantDobles());
	}

	@Test
	void constructorParametrizado()
	{
		Jugador jugador = new Jugador("azul", 1500, 39);
		
		assertEquals("azul", jugador.getNombre());
		assertEquals(1500, jugador.getDinero());
		assertEquals(39, jugador.getPosicion());
		assertEquals(0, jugador.getEstaEnCarcel());
		assertEquals(false, jugador.getTieneCartaSalida());
		assertEquals(0, jugador.getCantDobles());
	}

}


