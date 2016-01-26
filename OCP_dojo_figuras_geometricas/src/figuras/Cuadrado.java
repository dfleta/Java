package figuras;

public class Cuadrado extends FiguraGeometrica {
	
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
	
}
