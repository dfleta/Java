package utilidades;

/* https://docs.oracle.com/javase/tutorial/essential/regex/intro.html */

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;

public class MainCodigoBase {

	public static void main(String[] args) {

		String dni = "X12345678L";
		
		String regex = "(^\\d{8}[A-Z&&[^IÑOU]])|(^[XYZ]\\d{7}[A-Z&&[^IÑOU]])";
		/* X?(\\d{8})[A-Z&&[^IÑOU]] */
		
		Pattern patron = Pattern.compile(regex);
		
		Matcher matcher = patron.matcher(dni);
		
		System.out.println( matcher );
		
		if(matcher.find()){
				 System.out.println( dni + " PASS");
		}
		else System.out.println( "mal"); 
		
		System.out.println("\n **** Casos test DNI PASS **** \n"); 
		
		String[] casosTest = { // casos DNI PASS
		 		"78484464T","72376173A","01817200Q","95882054E","63587725Q",
		 		"26861694V","21616083Q","26868974Y","40135330P","89044648X",
		 		"80117501Z","34168723S","76857238R","66714505S","66499420A",
		 		// casos NIE PASS
		 		"X1234567T", "Y1234567T", "Z1234567T",
		 		// casos NIE FAIL
		 		"J1234567T", "H1234567T", "R1234567T",
		 		"X12345678X", "X1234T", "X1234567I"
		 		};
		
		for(String caso : casosTest){
			
			Matcher match = patron.matcher(caso);
			
			if(match.find()){
				 String cadenaMatchingRegex = match.group();
				 if(cadenaMatchingRegex == caso){
					 System.out.println(cadenaMatchingRegex + " PASS");
				 }
				 else System.out.println(cadenaMatchingRegex + " FAIL");
			}
			else System.out.println( "No se ha encotrado el patrón"); 
			
		}
		
		// test casos FAIL - utilizando ArrayList de Strings
		
					System.out.println("\n **** Casos test DNI FAIL **** \n"); 
					
					char[] letrasNoPermitidas = {'I', 'Ñ', 'O', 'U'};
					int numeroCasos = 15;
					String caso;
					
					ArrayList<String> casosTestFail = new ArrayList<>();
					
					for(int i = 1; i <= numeroCasos; i++){
						caso = "";
						for(int j = 1; j < 9; j++){
							Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 58); // 58 excluido
							caso = caso + String.valueOf( Character.toChars(caracterAscii) );
						}
						caso = caso + letrasNoPermitidas[ ThreadLocalRandom.current().nextInt(0, 4) ];
						casosTestFail.add(caso);
					}
					
					for(String casoFail : casosTestFail){
						
						Matcher match = patron.matcher(casoFail);
						
						if(match.find()){
							 String cadenaMatchingRegex = match.group();
							 if(cadenaMatchingRegex == casoFail){
								 System.out.println(cadenaMatchingRegex + " PASS");
							 }
							 else System.out.println(cadenaMatchingRegex + " FAIL");
						}
						else System.out.println( casoFail + " FAIL"); 
						
					}
										
					System.out.println("\n **** Casos test NIE FAIL **** \n"); 
					
					char[] letrasNIEPermitidas = {'X', 'Y', 'Z'};
					
					ArrayList<String> casosTestFailNIE = new ArrayList<>();
					
					for(int i = 1; i <= numeroCasos; i++){
						caso = "" + letrasNIEPermitidas[ ThreadLocalRandom.current().nextInt(0, 3) ];
						for(int j = 1; j < 8; j++){
							Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 58); // 58 excluido
							caso = caso + String.valueOf( Character.toChars(caracterAscii) );
						}
						caso = caso + letrasNoPermitidas[ ThreadLocalRandom.current().nextInt(0, 4) ];
						casosTestFailNIE.add(caso);
					}
					
					for(String casoFail : casosTestFailNIE){
						
						Matcher match = patron.matcher(casoFail);
						
						if(match.find()){
							 String cadenaMatchingRegex = match.group();
							 if(cadenaMatchingRegex == casoFail){
								 System.out.println(cadenaMatchingRegex + " PASS");
							 }
							 else System.out.println(cadenaMatchingRegex + " FAIL");
						}
						else System.out.println( casoFail + " FAIL"); 
					}	
		
	}

}
