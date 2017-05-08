package org.foobarspam.furnaceDIGuice.services;

import org.foobarspam.furnaceDIGuice.interfaces.Heater;
import org.foobarspam.furnaceDIGuice.types.RoomTemperature;

import com.google.inject.Inject;

public class Jedi implements Heater {
	
	private RoomTemperature temperature = null;
	
	@Inject
	public void setTemperature(RoomTemperature temperature){
		this.temperature = temperature;		
	}
	
	public void engage(){
		 temperature.incrementTemperature(this.toucheLightSable());
	}
	public void disengage(){
		this.forcePersuasion();
	}
	
	private double toucheLightSable(){
		final double lightSableTemperature = 1400; // in ºC
		return lightSableTemperature;
	}
	
	private void forcePersuasion(){
		temperature.incrementTemperature(-1400);
	}
	
	public void speak(){
    System.out.println("\n"
    		+ "\t  __.-._   \n"
    		+ "\t  '-._\"7' \n"
    		+ "\t   /'.-c   \n"
    		+ "\t   |  /T   \n"
    		+ "\t  _)_/LI   \n"
    		+ "\nDo or do not. There is no try ");
	}
}
