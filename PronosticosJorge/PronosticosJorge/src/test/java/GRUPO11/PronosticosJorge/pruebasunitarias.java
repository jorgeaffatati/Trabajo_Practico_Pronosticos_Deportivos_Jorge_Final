package GRUPO11.PronosticosJorge;

import static org.junit.Assert.*;

import org.junit.Test;

import GRUPO11.PronosticosJorge.*;

public class pruebasunitarias {
	Procesador procesador = new Procesador();
	@Test
	public void ejecutar(){
	procesador.LeerarchivoResultados("Resultados.csv");
	procesador.leerArchivoPronosticos("Pronosticos.csv");
	}
	@Test
	public void testPartidos(){
		
		
		assertEquals(procesador.getCantidadDePartidos(), 14);
	}
	
	@Test
	public void testParticipantes(){
				
		assertEquals(procesador.getCantidadDeParticipantes(), 2);				
	}
	
	@Test
	public void testRondas(){
				
		assertEquals(procesador.getCantidadDeRondas(), 2);				
	}
	
}
