package figuras;

public class Elipse extends FiguraGeometrica {
	
	/* Elipse no hereda de Círuclo porque la relación IS-A o ES-Una 
	 * trata sobre el comportamiento de objeto. 
	 * Una elipse no se comporta como un círculo. 
	 * El comportamiento determina la programación por contrato de la clase Elipse y sus métodos.
	 * Una instancia de Círculo no verificaría la condición semiejeMayor != semiejeMenor,
	 * por lo que se violaría el principio de substitución de Liskov (LSP).
	 * */
	
	private double semiejeMayor = 0d;
	private double semiejeMenor = 0d;
	private final double PI = Math.PI;
	
	public Elipse() {
		super();
	}
	
	public Elipse(double semiejeMayor, double semiejeMenor) {
		super();
		this.semiejeMayor = semiejeMayor;
		this.semiejeMenor = semiejeMenor;		
	}

	public Elipse(String nombre, double semiejeMayor, double semiejeMenor) {
		super(nombre);
		this.semiejeMayor = semiejeMayor;
		this.semiejeMenor = semiejeMenor;		
	}
	
	public double getSemiejeMayor() {
		return this.semiejeMayor;
	}

	public void setSemiejeMayor(double semiejeMayor) {
		this.semiejeMayor = semiejeMayor;
	}

	public double getSemiejeMenor() {
		return this.semiejeMenor;
	}

	public void setSemiejeMenor(double semiejeMenor) {
		this.semiejeMenor = semiejeMenor;
	}

	@Override
	public double area() {
		return PI * getSemiejeMayor() * getSemiejeMenor();
	}



}
