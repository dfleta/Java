package composite;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// caso test: crear simple item y testear su nombre
		
		System.out.println("\n *** crear item simple y testear su nombre *** \n");
		
		SimpleItem equipo = new SimpleItem("Lakers");
		
		System.out.println("equipo: " + equipo.getNombre());
		
		// crear item compuesto y testear su nombre
		
		System.out.println("\n *** crear item compuesto y testear su nombre *** \n");
		
		CompuestoItem divisionPacific = new CompuestoItem("Pacific");
		
		System.out.println("división: " + divisionPacific.getNombre());
		
		// añadir item simple a compuesto y comprobar nombre
		
		System.out.println("\n *** añadir item simple a compuesto y comprobar nombre *** \n");
		
		divisionPacific.anhadir(equipo);
		
		if(divisionPacific.getHijos().isEmpty()){
			System.out.println("ERROR: No se ha añadido item equipo");			
		}
		else {
			System.out.println("OK: se ha añadido item equipo: " + divisionPacific.getHijos().get(0).getNombre());		
		}
		
		/* -
		// eliminar item simple de compuesto y comprobar lista vacia
		
		System.out.println("\n *** eliminar item simple de compuesto y comprobar lista vacia *** \n");
		
		divisionPacific.quitar(equipo);
		
		if(divisionPacific.getHijos().isEmpty()){
			System.out.println("OK: se ha eliminado item. Longitud lista = " + divisionPacific.getHijos().size());			
		}
		else {
			System.out.println("ERROR: No se ha eliminado equipo");		
		}
		- */
		
		// recorrer un item compuesto mostrando su nombre y el de sus hijos: 1 hijo, profundidad 1
		
		System.out.println("\n *** recorrer un item compuesto mostrando su nombre y el de sus hijos: 1 hijo, profundidad 1 *** \n");
		
		divisionPacific.iterable();
		
		// añadir varios hijos y recorrer un item compuesto mostrando su nombre y el de sus hijos: n hijos, profundidad 1
		
		System.out.println("\n ***añadir varios hijos desde array de strings y recorrer un item compuesto mostrando su nombre y el de sus hijos: n hijos, profundidad 1 *** \n");
		
		CompuestoItem division = new CompuestoItem("Atlantic");
		
		String[] equiposAtlantic = {"Celtics", "Nets", "Knicks", "76ers", "Raptors"};
		
		for(String nombreEquipo : equiposAtlantic){
			equipo = new SimpleItem(nombreEquipo);
			division.getHijos().add(equipo);			
		}
		
		if(division.getHijos().isEmpty()){
			System.out.println("ERROR: No se ha añadido item equipo");			
		}
		else {
			System.out.println("OK: se han añadido " + division.getHijos().size() + " equipos");		
		}
		
		division.iterable();
		
		
		// recorrer un item compuesto mostrando su nombre y el de sus hijos: n hijos, profundidad n	
		
		System.out.println("\n *** recorrer un item compuesto por otros compuestos, mostrando su nombre y el de sus hijos: n hijos, profundidad n *** \n");
		
		CompuestoItem liga = new CompuestoItem("nba"); 
		CompuestoItem conferencia = new CompuestoItem("Este"); 
		
		conferencia.anhadir(division);
		
		liga.anhadir(conferencia);
		
		liga.iterable();
		
		// crear un elemento compuesto de simples a partir de un array de nombres
		
		System.out.println("\n *** crear un elemento compuesto de simples a partir de un array de strings *** \n");
		
		String[] equiposCentral = {"Bulls", "Cavs", "Pistons", "Pacers", "Bucks"};
		
		CompuestoItem divisionCentral = new CompuestoItem("Central");
		
		divisionCentral.composite(equiposCentral);
		
		divisionCentral.iterable();			
		
		// test metodo composite de compuestos a partir de un array de items simples

		System.out.println("\n *** crear un elemento compuesto de elementos compuestos a partir de un array de objetos simples *** \n");
		
		String[] equiposSouthEast = {"Heat", "Hawks", "Hornets", "Wizzards", "Magic"};
		
		ArrayList<Item> equiposSouthEastItems = new ArrayList<Item>();
		
		for( String nombre : equiposSouthEast){
			SimpleItem item = new SimpleItem(nombre);
			equiposSouthEastItems.add(item);
		}
		
		CompuestoItem divisionSouthEast = new CompuestoItem("SouthEast");
		
		divisionSouthEast.composite(equiposSouthEastItems);
		
		divisionSouthEast.iterable();
		
		// test metodo composite de compuestos a partir de un array de items (objetos) compuestos
		
		System.out.println("\n *** crear un elemento compuesto de elementos compuestos a partir de un array de objetos compuestos *** \n");
		
		ArrayList<Item> divisiones = new ArrayList<Item>();
		
		// divisiones.add(division);
		divisiones.add(divisionCentral);
		divisiones.add(divisionSouthEast);
		
		conferencia.composite(divisiones);
		
		conferencia.iterable();	
		
		
		// eliminar un hijo entre varios, profundidad 1
		
		System.out.println("\n *** eliminar un hijo a profundidad n *** \n");

		liga.quitar("Atlantic");
		
		liga.iterable();	
		
		// Crea la conferencia Oeste completa y añadela a la liga; muestra por pantalla la liga completa
		
		System.out.println("\n *** Liga NBA completa con sus conferencias, divisiones y equipos *** \n");

	}
}
