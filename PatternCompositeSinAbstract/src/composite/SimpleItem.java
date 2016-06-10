package composite;

public class SimpleItem extends Item {
	
	public SimpleItem(String nombre){
		super(nombre);
		this.setCompuesto(false);
	}
}
