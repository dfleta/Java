package nif;

import nif.TablaAsignacion;

import expresionesRegulares.RegEx;

public abstract class Nif {

	protected String nif  			= null;
	protected Boolean numeroSano 	= false;
	protected Boolean letraFinalSana = false;
	protected Boolean nifSano 		 = false;
	// Composición (agregación) "Has - a" / "Tiene - un"
	protected TablaAsignacion tabla = new TablaAsignacion();
	
	protected String formatoValidoNIF = null;
	
	protected RegEx objetoRegEx = null;	

	
	
	public Nif(String nif) {
		this.nif = nif;
		// inicializamos el objeto expresión regular que realizará la validación del DNI
		// objetoRegEx = new RegEx(this.formatoValidoNIF, this.nif);
	}


	public RegEx getObjetoRegEx() {
		return this.objetoRegEx;
	}




	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	private void setNumeroSano(Boolean valor){
		this.numeroSano = valor;
	}
	
	public Boolean getNumeroSano(){
		return this.numeroSano;
	}
	
	private void setLetraFinalSana(Boolean valor){
		this.letraFinalSana = valor;
	}

	public Boolean getLetraFinalSana(){
		return this.letraFinalSana;
	}
	
	public void setNifSano(Boolean valor){
		this.nifSano = valor;
	}
	
	public Boolean getNifSano(){
		return this.nifSano;
	}
	
	public String getFormatoValidoNIF() {
		return this.formatoValidoNIF;
	}

	public void setFormatoValidoNIF(String formatoValidoDNI) {
		this.formatoValidoNIF = formatoValidoDNI;
		// el objeto expresión regular está creado y hay que actualizar la expresión regular
		// objetoRegEx.setExpresionRegular( getFormatoValidoNIF());
	}
	
	/*
	 * Lógica 
	 */

	/* Interfaz Pública */
	

	public Boolean checkNIF(){
		// El DNI es válido si su formato es correcto y si la letra asociada es la adecuada al número
		setNifSano( checkFormatoNIF() && checkLetraValida() );
		return getNifSano();
	}
	
	public Boolean checkFormatoNIF(){
		setNumeroSano( this.objetoRegEx.matching() );
		return getNumeroSano();
	}
	
	public abstract Boolean checkLetraValida();
	
	public Character getParteAlfabeticaDni() {
		return nif.charAt(nif.length() - 1);
	}
	
}
