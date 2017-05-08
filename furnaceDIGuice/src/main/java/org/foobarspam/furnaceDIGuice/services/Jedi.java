package org.foobarspam.furnaceDIGuice.services;

import org.foobarspam.furnaceDIGuice.interfaces.Heater;
import org.foobarspam.furnaceDIGuice.types.RoomTemperature;

public class Jedi implements Heater {
	
	public void engage(RoomTemperature temperature){
		 temperature.incrementTemperature(this.toucheLightSable());
	}
	public void disengage(RoomTemperature temperature){
		this.forcePersuasion(temperature);
	}
	
	private double toucheLightSable(){
		final double lightSableTemperature = 1400; // in ºC
		return lightSableTemperature;
	}
	
	private void forcePersuasion(RoomTemperature temperature){
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
