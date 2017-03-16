package org.foobarspam.figuras;

import org.foobarspam.draw.Drawable;

public class Circulo extends FiguraGeometrica implements Drawable {
	
	private double radio = 0d;
	// el valor de la propiedad PI no puede variar => final
	private final double PI = Math.PI;
	
	/* Sobrecarga de constructores: utilizo el constructor de la superclase FiguraGeometrica */
	
	public Circulo(){
		super();
	}
	
	public Circulo(double radio){
		super();
		this.radio = radio;
	}
	
	public Circulo(String nombre, double radio){
		super(nombre);
		this.radio = radio;
	}

	@Override
	public double area() {
		// math.pow(numero, potencia) = elevar un número a una potencia
		return PI * Math.pow(this.radio, 2);
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
