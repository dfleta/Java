package expresionesRegulares;

public class MainRegEx {

	public static void main(String[] args) {
		
		String objetivo = "12345678P";
		String patron = "(^\\d{8}[A-Z&&[^IÑOU]])|(^[XYZ]\\d{7}[A-Z&&[^IÑOU]])";
		
		RegEx objetoRegEx = new RegEx(patron, objetivo);
		
		System.out.println(objetoRegEx.getExpresionRegular());
		System.out.println(objetoRegEx.getObjetivo());
		
		System.out.println(objetoRegEx.getPattern().toString());
		System.out.println(objetoRegEx.getMatcher().toString());
	
		
		if ( objetoRegEx.matching() ){
			System.out.println("encontrado! " + objetoRegEx.grupo() ); 
		}
		else 
			System.out.println( "No se ha encontrado el patron");
		
		
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
			
			RegEx objetoRegExpDniNie = new RegEx(patron, caso);
			
			if( objetoRegExpDniNie.matching() ){
				 String cadenaMatchingRegex =objetoRegExpDniNie.grupo();
				 if(cadenaMatchingRegex == caso){
					 System.out.println(cadenaMatchingRegex + " PASS");
				 }
				 else System.out.println(cadenaMatchingRegex + " FAIL");
			}
			else System.out.println( "No se ha encotrado el patrón"); 
			
		}
		
		
	}

}
