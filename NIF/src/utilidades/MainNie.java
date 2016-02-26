package utilidades;

import nif.Nie;

public class MainNie {

	public static void main(String[] args) {
		
		Nie nie = new Nie("Y1234567X");
		
		System.out.println(nie.getNie());
		
		
		if(nie.checkNIF()){
			System.out.println("PASS");
		}
		else
			System.out.println("FAIL");
		
	

	}

}
