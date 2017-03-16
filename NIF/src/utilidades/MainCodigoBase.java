package utilidades;

/* https://docs.oracle.com/javase/tutorial/essential/regex/intro.html */

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;

public class MainCodigoBase {

	public static void main(String[] args) {

		String dni = "X1234567L";
		
		String regex = "(^\\d{8}[A-Z&&[^IÑOU]])|(^[XYZ]\\d{7}[A-Z&&[^IÑOU]])";
		/* X?(\\d{8})[A-Z&&[^IÑOU]] */
		
		Pattern patron = Pattern.compile(regex);
		
		Matcher matcher = patron.matcher(dni);
		
		System.out.println("Este es el matcher en bruto: " + matcher);
		
		if(matcher.find()){
				 System.out.println( dni + " PASS");
		}
		else System.out.println( "mal"); 
		
		
		// test de casos DNI y NIE correctos
		
		System.out.println("\n **** Casos test DNI PASS **** \n"); 
		
		String[] casosTest = { 
				// casos DNI PASS
		 		"78484464T","72376173A","01817200Q","95882054E","63587725Q",
		 		"26861694V","21616083Q","26868974Y","40135330P","89044648X",
		 		"80117501Z","34168723S","76857238R","66714505S","66499420A",
		 		// casos NIE PASS
		 		"X1234567T", "Y1234567T", "Z1234567T",
		 		// casos NIE FAIL
		 		"J1234567T", "H1234567T", "R1234567T",
		 		"X12345678X", "X1234T", "X1234567I"
		 		};
		
		Short indexCaso = 0;
		for(String caso : casosTest){
			
			indexCaso++;
			
			Matcher match = patron.matcher(caso);
			
			if(match.find()){
				 String cadenaMatchingRegex = match.group();
				 if(cadenaMatchingRegex == caso){
					 System.out.println(indexCaso.toString() + ": " + cadenaMatchingRegex + " PASS");
				 }
				 else System.out.println(cadenaMatchingRegex + " regex FAIL");
			}
			else System.out.println( "No se ha encotrado el patrón"); 
			
		}
		
		
		// casos Test DNI incorrectos - utilizando ArrayList de Strings
		
		System.out.println("\n **** Casos test DNI FAIL **** \n"); 
		
		// Creamos un ArrayList de Casos Test Fail
		
		char[] letrasNoPermitidas = {'I', 'Ñ', 'O', 'U'};
		int numeroCasos = 15;
		String caso;
					
		ArrayList<String> casosTestFail = new ArrayList<>();
		
		for(int i = 1; i <= numeroCasos; i++){
			// Generamos un String de 8 dígitos entre el 0 y el 9
			caso = "";
			for(int j = 1; j < 9; j++){
			Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 58); // 58 excluido
				caso = caso + String.valueOf( Character.toChars(caracterAscii) );
			}
		// y agregamos una de las letras no permitidas en la ultima posicion
		caso = caso + letrasNoPermitidas[ ThreadLocalRandom.current().nextInt(0, 4) ];
		// una vez formado el caso test incorrecto, lo metemos en el ArrayList
		casosTestFail.add(caso);
		}
		
		// testeamos nuestra regex contra los casos test DNI incorrectos
					
		for(String casoFail : casosTestFail){
						
			Matcher match = patron.matcher(casoFail);
					
			if(match.find()){
				 String cadenaMatchingRegex = match.group();
				 System.out.println(cadenaMatchingRegex + " regex FAIL");
			}
			else System.out.println( casoFail + " PASS");						
		}
		
		
		// Casos Test NIE FAIL
		
		System.out.println("\n **** Casos test NIE FAIL **** \n"); 
				
		char[] letrasNIEPermitidas = {'X', 'Y', 'Z'};
					
		ArrayList<String> casosTestFailNIE = new ArrayList<>();
					
		for(int i = 1; i <= numeroCasos; i++){
			
			// generamos un string que comienza por una de las tres letras permitidas
			caso = "" + letrasNIEPermitidas[ ThreadLocalRandom.current().nextInt(0, 3) ];
			
			// agregamos 7 digitos a ese string
			for(int j = 1; j < 8; j++){
				Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 58); // 58 excluido
				caso = caso + String.valueOf( Character.toChars(caracterAscii) );
			}
			
			// agregamos una letra no permitida al final del string
			caso = caso + letrasNoPermitidas[ ThreadLocalRandom.current().nextInt(0, 4) ];
			casosTestFailNIE.add(caso);
		}
				
		// testeamos nuestra regex contra los casos test NIE incorrectos
		
		for(String casoFail : casosTestFailNIE){
						
			Matcher match = patron.matcher(casoFail);
						
			if(match.find()){
				 String cadenaMatchingRegex = match.group();
				 System.out.println(cadenaMatchingRegex + " regex FAIL");
			}
			else System.out.println( casoFail + " PASS"); 
		}	
	}
}
