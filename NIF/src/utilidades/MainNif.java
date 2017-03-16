package utilidades;

import nif.Nif;

public class MainNif {
	
	public static void main(String[] args) {
		
		Nif nif = new Nif("1234567X");
		
		System.out.println(nif.getNif());
		
		
		if(nif.checkNIF()){
			System.out.println("PASS");
		}
		else
			System.out.println("FAIL");
		
	

	}

}
