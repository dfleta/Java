package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import draw.Drawable;
import draw.Drawables;
import figuras.Circulo;
import figuras.Cuadrado;
import figuras.Elipse;
import figuras.Rectangulo;


public class DrawablesTest {
	

	@Test
	public void testDibujarDrawables() {
		
		ArrayList<Drawable> figuras = new ArrayList<>();
		
		Elipse elipse = new Elipse("elipse", 3, 4);
		Circulo circulo = new Circulo("círculo", 5);
		Cuadrado cuadrado = new Cuadrado("cuadrado", 2);
		Rectangulo rectangulo = new Rectangulo("rectángulo", 4, 5);
		
		figuras.add(elipse);
		figuras.add(circulo);
		figuras.add(cuadrado);
		figuras.add(rectangulo);
			 
		// Dibujémoslas
		
		Drawables.dibujarDrawables(figuras);
		
		// Las interfaces son un tipo de dato
		// figura es drawable pero no todo drawable es una figura
		
		Drawable circulito = new Circulo("círculo", 5);
		
		circulito.draw();
		
		// circulito.area(); no compila: como circulito es de tipo Drawable, no dispone del método area()
		
		
	}

}
