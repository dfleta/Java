package utilidades;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import dni.DniCif;

public class MainDniCif {

	public static void main(String[] args) {
		
		int numeroCasos = 25;
		String caso;
		
		ArrayList<String> casosTest = new ArrayList<>();
		
		for(int i = 1; i <= numeroCasos; i++){
			caso = "";
			for(int j = 1; j <= 9; j++){
				Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 59); // 58 excluido
				caso = caso + String.valueOf( Character.toChars(caracterAscii) );
			}
			Integer caracterAscii = ThreadLocalRandom.current().nextInt(65, 91);
			caso = caso + String.valueOf( Character.toChars(caracterAscii) );
			casosTest.add(caso);
		}
		
		for ( String casoTest : casosTest ){
			System.out.println(casoTest);
		}
		
		for(String dni : casosTest){
			DniCif objetoDniCif = new DniCif(dni);
			System.out.println(objetoDniCif.getDni());
			
			objetoDniCif.checkCIF();
			
			System.out.println("dni --> " + objetoDniCif.getNumeroSano());
			System.out.println("letra --> " + objetoDniCif.getLetraSana());
			System.out.println("La letra es --> " + objetoDniCif.obtenerLetra());
		}

	}

}
