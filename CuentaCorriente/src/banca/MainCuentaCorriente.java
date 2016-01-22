/*
 * Contiene anotaciones del capítulo 4 del libro Beginning Java Programming: The Object-Oriented Approach
 * John Wiley & Sons, Inc. 
 * ISBN: 978-1-118-73949-5
 */

package banca;

import dni.DniCif;

public class MainCuentaCorriente {
	
	public static void main(String[] args) {
		/* 
		A special method definition that can be used to run your application.
		
		the main method must be public , static , return nothing ( void ), and take a single argument: an array of
		strings, String[] . The name of the argument can be changed, but by convention, args is used. The
		reason for this is that this method argument will contain the list of arguments that was passed to Java.
		
		mixing in this main method with the class definition is not a good idea: 
		which class of objects should be responsible for the behavior of creating some cuentas corrientes?
		
		“I just want my program to create some cuentas corrientes.” 
		So what you can do is add a class, called MainCuentasCorrientes, to hold a single main method:
		 
		*/
		
		DniCif dni = new DniCif("12345678");
		
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.setNombre("Facundo");
		System.out.println(cuenta.getNombre());
		cuenta.ingresarDinero(100);
		System.out.println(cuenta.getSaldo());
		cuenta.retirarDinero(500);
		System.out.println(cuenta.getSaldo());
		System.out.println(cuenta.saldoNegativo());
		cuenta.setDni(dni);
		cuenta.consultarCuenta();
		
		CuentaCorriente otra = new CuentaCorriente("Facundo", "Campazzo", dni,
				"Bolson cerrado", "999888777", 500);
		otra.consultarCuenta();
		
		CuentaCorriente nueva = new CuentaCorriente();
		nueva.setNombre("nueva");
		System.out.println(nueva.getNombre());
		System.out.println("apellidos: " + nueva.getApellidos());
	}

}
