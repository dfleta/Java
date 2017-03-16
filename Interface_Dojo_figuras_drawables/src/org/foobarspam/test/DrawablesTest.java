package org.foobarspam.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.foobarspam.figuras.Circulo;
import org.foobarspam.figuras.Cuadrado;
import org.foobarspam.figuras.Elipse;
import org.foobarspam.figuras.Rectangulo;
import org.junit.BeforeClass;
import org.junit.Test;

import org.foobarspam.draw.Drawable;
import org.foobarspam.draw.Drawables;


public class DrawablesTest {
	
	private static ArrayList<Drawable> figuras;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		figuras = new ArrayList<>();
		
		Elipse elipse = new Elipse("elipse", 3, 4);
		Circulo circulo = new Circulo("círculo", 5);
		Cuadrado cuadrado = new Cuadrado("cuadrado", 2);
		Rectangulo rectangulo = new Rectangulo("rectángulo", 4, 5);
		
		figuras.add(elipse);
		figuras.add(circulo);
		figuras.add(cuadrado);
		figuras.add(rectangulo);
		
		assertEquals(figuras.size(), 4);
		
	}
	
	@Test
	public void figuras_incluidas_en_ArrayList_figuras(){
		assertEquals(figuras.size(), 4);
	}
	
	
	@Test
	public void testDibujarDrawables() {
		
		// Dibujemos las figuras
		
		Drawables.dibujarDrawables(figuras);
		
		// Las interfaces son un tipo de dato
		// figura es drawable pero no todo drawable es una figura
	}
	
	@Test
	public void testPolimorfismo(){
		
		Drawable circulito = new Circulo("círculo", 5);
		
		assertTrue(circulito instanceof Drawable);
		assertTrue(circulito instanceof Circulo);
		
		// vista Drawable de circulito => acceso al metodo draw de la interfaz e implementado!
		
		circulito.draw();
		
		// vista Drawable de circulito => acceso al metodo applyTheme de la interfaz e implementado!
		
		circulito.applyTheme();
		
		// circulito.area(); // no compila: como circulito es de tipo Drawable, no dispone del método area()
		
		Circulo vistaCirculo;
		vistaCirculo = (Circulo) circulito;
		
		assertEquals(Math.PI * Math.pow(5, 2), vistaCirculo.area(), 0.1); 
	}
	
	@Test
	public void testAplicarTema(){

		Drawables.aplicarTema(figuras);
	
	}
	

}
