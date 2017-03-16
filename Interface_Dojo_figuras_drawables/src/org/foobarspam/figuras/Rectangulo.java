package org.foobarspam.figuras;

import org.foobarspam.draw.Drawable;

public class Rectangulo extends FiguraGeometrica implements Drawable {

	private double altura 	= 0d;
	private double anchura 	= 0d;

	/* Sobrecarga de constructores: utilizo el constructor de la superclase FiguraGeometrica */
	
	public Rectangulo(){
		super(); /* invocamos al constructor sin parámetro de la superclase FiguraGeometrica */
	}
		
	public Rectangulo(double altura, double anchura){
		super();
		this.altura = altura;
		this.anchura = anchura;
	}
	
	public Rectangulo(String nombre, double altura, double anchura){
		super(nombre); /* invocamos al constructor con parámetro String nombre de la superclase */
		this.altura = altura;
		this.anchura = anchura;
	}
	
	public double getAltura(){
		return this.altura;
	}
	
	public void setAltura(double altura){
		this.altura = altura;
	}
	
	public double getAnchura(){
		return this.anchura;
	}
	
	public void setAnchura(double anchura){
		this.altura = anchura;
	}
	
	@Override
	public double area() {
		// ocultación de la información => acceder a las propiedades mediante get
		return getAltura() * getAnchura();
	}

	@Override
	public void draw() {
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
