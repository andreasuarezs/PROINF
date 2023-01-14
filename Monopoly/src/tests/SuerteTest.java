package tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import main.Suerte;

class SuerteTest {

	@Test
	void constructorParametrizado() 
	{
		Suerte suerte = new Suerte("descripcion1");
		
		assertEquals("descripcion1", suerte.getDescripcion());
	}

}
