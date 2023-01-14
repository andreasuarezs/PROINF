package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import main.Tablero;

class TableroTest {

	@Test
	void constructorDefecto() 
	{
		Tablero tablero = new Tablero();
		
		assertEquals(40, tablero.getCasillas().length);
		assertEquals(0, tablero.getAcumuladoParking());
	}

}
