package nif;

import java.io.IOException;

import expresionesRegulares.RegEx;

public class DniCif {
	
		private String dni  = null;
		private Boolean numeroSano = false;
		private Boolean letraSana 	= false;
		private Boolean dniCifSano  = false;
		// Composición (agregación) "Has - a" / "Tiene - un"
		private TablaAsignacion tabla = new TablaAsignacion();
		
		private String formatoValidoDNI = "(^\\d{8}[A-Z&&[^IÑOU]])";
		
		private RegEx objetoRegEx = null;		
		

		/* Constructores */
		
		public DniCif(String dni) {
			this.dni = dni;
			// inicializamos el objeto expresión regular que realizará la validación del DNI
			objetoRegEx = new RegEx(this.formatoValidoDNI, this.dni);
		}
		
		/* Encapsulacion */
		
		public void setDni(String cadena){
			this.dni = cadena;
		}

		public String getDni(){
			return this.dni;
		}
	
		private void setNumeroSano(Boolean valor){
			this.numeroSano = valor;
		}
		
		public Boolean getNumeroSano(){
			return this.numeroSano;
		}
		
		private void setLetraSana(Boolean valor){
			this.letraSana = valor;
		}
	
		public Boolean getLetraSana(){
			return this.letraSana;
		}
		
		public void setDniCifSano(Boolean valor){
			this.dniCifSano = valor;
		}
		
		public Boolean getDniCifSano(){
			return this.dniCifSano;
		}
		
		public String getFormatoValidoDNI() {
			return this.formatoValidoDNI;
		}

		public void setFormatoValidoDNI(String formatoValidoDNI) {
			this.formatoValidoDNI = formatoValidoDNI;
			// el objeto expresión regular está creado y hay que actualizar la expresión regular
			objetoRegEx.setExpresionRegular( getFormatoValidoDNI());
		}

			
		/*
		 * Lógica 
		 */
	
		/* Interfaz Pública */
		

		public Boolean checkCIF(){
			// El DNI es válido si su formato es correcto y si la letra asociada es la adecuada al número
			setDniCifSano( checkFormatoDNI() && checkLetraValida() );
			return getDniCifSano();
		}
		
		public Boolean checkFormatoDNI(){
			setNumeroSano( this.objetoRegEx.matching() );
			return getNumeroSano();
		}
		
		public Boolean checkLetraValida() {
			try {
				setLetraSana( getParteAlfabeticaDni() == obtenerLetra() );
				return getLetraSana();
			}
			catch(IOException ioexcepcion){
				return false;
			}	
		}
						
		public Character obtenerLetra() throws IOException{
			// calcularLetra no puede ejecutarse si antes no se cumplen las condiciones previas en checkFormatoDNI
			// y checkLetra
			if ( getNumeroSano() ){
				return this.tabla.calcularLetra( getParteNumericaDni() );
			}
			else 
				throw new IOException("Parte numérica del DNI no está sana");
		}
			
		public String getParteNumericaDni() {
			return (String) dni.substring(0, dni.length() - 1);
		}
		
		public Character getParteAlfabeticaDni() {
			return dni.charAt(dni.length() - 1);
		}
		


}
