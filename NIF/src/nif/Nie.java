package nif;

import java.io.IOException;

import expresionesRegulares.RegEx;

public class Nie extends Nif {

	public Nie(String nie) {
		super(nie);
		this.setFormatoValidoNIF( "(^[XYZ]\\d{7}[A-Z&&[^IÑOU]])" );
		this.objetoRegEx = new RegEx( this.getFormatoValidoNIF(), this.getNie());
	}
	
	public String getNie(){
		return super.getNif();
	}
	
	public void setNie(String nie){
		super.setNif(nie);
	}
	/*
	public Boolean checkNIF(){
		// El DNI es válido si su formato es correcto y si la letra asociada es la adecuada al número
		setNifSano( checkFormatoNIF() && checkLetraValida() );
		return getNifSano();
	}
	*/
	
	public Boolean checkLetraValida(){
		try {
			setLetraFinalSana( getParteAlfabeticaDni() == obtenerLetra() );
			return getLetraFinalSana();
		}
		catch(IOException ioexcepcion){
			return false;
		}	
	}
	

}
