package org.foobarspam.draw;

import java.util.ArrayList;

import org.foobarspam.figuras.FiguraGeometrica;

public class Drawables {
	
	public static void dibujarDrawables(ArrayList<Drawable> lista){
		
		for(Drawable elemento: lista){
			elemento.draw();
		}
		
	}
	
	public static void aplicarTema(ArrayList<Drawable> lista){

		for(Drawable elemento: lista){
			try {
				elemento.applyTheme();
			}
			catch(UnsupportedOperationException excepcion){
				/* 
				 * Recogemos la excepción lanzada por el método default applyTheme() de la interfaz
				 * de aquellas figuras a las que no se le puede aplicar un tema
				 * Las excepciones son un objeto => recogemos el mensaje de la excepción UnsupportedOperationException
				 * 
				 * elemento es un objeto de tipo Drawable => no dispone del método getNombre() del tipo FiguraGeometrica
				 * El objeto elipse es de tipo Elipse y de tipo FiguraGeometrica.
				 * Podemos hacer un downcasting del tipo Drawable a FiguraGeometica, SÓLO porque 
				 * hemos asignado una referencia del tipo Drawable (elemento) al objeto elipse (que es FiguraGeometrica por herencia)
				 * ¡Polimorfismo! elipse es de tipo Elipse, FiguraGeometrica y Drawable
				 * Pero la regla es: un pez es nadador (interfaz), aunque no todo nadador (intefaz) es un pez
				 */

				FiguraGeometrica figura = (FiguraGeometrica) elemento;
				System.out.println(excepcion.getMessage() + " para la figura: " + figura.getNombre());
			}
		}
		
	}
	
}
