package composite;

public class CompuestoItem extends Item {
	
	public CompuestoItem(String nombre){
		super(nombre);
		this.setCompuesto(true);
	}	
}
