package org.foobarspam.figuras;

import org.foobarspam.draw.Drawable;

public class Cuadrado extends FiguraGeometrica implements Drawable {
	
	/* Cuadrado no hereda de Rectángulo porque la relación IS-A o ES-Una 
	 * trata sobre el comportamiento de objeto. 
	 * Un cuadrado no se comporta como un rectángulo. 
	 * El comportamiento determina la programación por contrato de la clase Cuadrado y sus métodos.
	 * Una instancia de Rectángulo no verificaría la condición anchura = altura,
	 * por lo que se violaría el principio de substitución de Liskov (LSP).
	 * */
	
	double lado = 0d;

	/* Sobrecarga de constructores: utilizo el constructor de la superclase FiguraGeometrica */
	
	public Cuadrado() {
		super();
	}

	public Cuadrado(double lado){
		super();
		this.lado = lado;
	}
	
	public Cuadrado(String nombre, double lado){
		super(nombre);
		this.lado = lado;
	}
	
	public double getLado(){
		return this.lado;
	}
	
	public void setlado(double lado){
		this.lado = lado;
	}
	
	@Override
	public double area(){
		return Math.pow(getLado(), 2);
	}
	
	// implementar método interfaz Drawable
	public void draw(){
		System.out.println("Esto es un: " + this.getNombre());
	}
	
	/* 
	 * Eliminar en la sobreesceritura un throw Exception de un método default de la interfaz
	 * está permitido aunque sea imponer restricciones a la definición del método...
	 * ... pero la excepción ha de ser recogida por el caller.
	 */
	
	@Override
	public void applyTheme(){
		System.out.println("Aplicado un tema chulo a: " + this.getNombre());
	}
	
}
