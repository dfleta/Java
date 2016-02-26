package expresionesRegulares;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegEx {
	
	private String objetivo = null;
	private String expresionRegular = null;
	private Pattern pattern = null;
	private Matcher matcher = null;

	/* 
	 * Constructor 
	 * 
	 */
	
	public RegEx(String expresionRegular, String objetivo) {		
		this.expresionRegular 	= expresionRegular;
		this.objetivo 			= objetivo;
		construccionPattern( getExpresionRegular() );
		construccionMatcher( getObjetivo() );		
	}

	
	/* 
	 * Acceso a las propiedades 
	 * 
	 */
	
	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getExpresionRegular() {
		return expresionRegular;
	}

	public void setExpresionRegular(String expresionRegular) {
		this.expresionRegular = expresionRegular;
	}

	public Pattern getPattern() {
		return this.pattern;
	}

	public void setPattern(Pattern patron) {
		this.pattern = patron;
	}
	
	public Matcher getMatcher() {
		return this.matcher;
	}


	public void setMatcher(Matcher matcher) {
		this.matcher = matcher;
	}
	
	
	/*
	 * Lógica
	 * 
	 */
	

	private void construccionPattern(String expresionRegular){
		Pattern patron = Pattern.compile(expresionRegular);
		this.setPattern(patron);		
	}
	
	private void construccionMatcher(String objetivo){
		Matcher matcher = pattern.matcher(objetivo);
		this.setMatcher(matcher);		
	}

	public Boolean matching(){
		// true si existe matching entre el patrón y el objetivo
		if(matcher.find()){
			return true; 
		}
		else 
			return false;
	}
	
	public String grupo(){
		// devuelve la coincidencia con el patrón
		return this.getMatcher().group();
	}

}
