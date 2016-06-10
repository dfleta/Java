package composite;

import java.util.ArrayList;

public class Item implements Componible, Iterable {

		private String nombre = "";
		private boolean compuesto;
		private ArrayList<Item> hijos;
		
		public Item(String nombre){
			this.setNombre(nombre);
			this.hijos =  new ArrayList<>();
		}
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public boolean isCompuesto() {
			return compuesto;
		}
		public void setCompuesto(boolean compuesto) {
			this.compuesto = compuesto;
		}
		
		public ArrayList<Item> getHijos() {
			return hijos;
		}
		
		
		public void anhadir(Item item) {
			this.hijos.add(item);
		}

		// sobrecarga del método quitar para eliminar por referencia al objeto
		
		public void quitar(Item item) {
			this.hijos.remove(item);
		}
		
		// sobrecarga del método quitar para eliminar por la propiedad nombre del elemento
			
		public void quitar(String nombre){
			for( Item item : this.getHijos() ) {
				if(item.getNombre() == nombre) {
					this.getHijos().remove(item);
					break;
				}
				else {
						if(item.isCompuesto()) {
							item.quitar(nombre);			
						}
						else;
				}
			}
		}
		
		String repetir(String caracteres, int repeticiones){
			String frase = "";
			for(int i=1; i<=repeticiones; i++){
				frase = frase + caracteres;
			}
			return frase;		
		}
		
		@Override
		public void iterable() {
			
			System.out.println(this.getNombre());
			for( Item item : this.getHijos() ){
				if(item.isCompuesto()){
					item.iterable();				
				}
				else {
					System.out.println(this.repetir("-", 10) + item.getNombre());
				}
			}
		}
		
		// añadir items simples a partir de su nombre (según exigencias del libro)
		
		@Override
		public void composite(String[] nombres){
			for(String nombre : nombres){
				Item item = new Item(nombre);
				item.setCompuesto(false);
				this.anhadir(item);
			}
		}
		
		// sobrecarga del método composite para añadir items compuestos o simples
		
		public void composite(ArrayList<Item> items){
			for(Item item : items ){
				this.anhadir(item);
			}
		}

}
