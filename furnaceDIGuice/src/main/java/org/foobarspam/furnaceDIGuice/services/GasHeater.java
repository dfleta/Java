package org.foobarspam.furnaceDIGuice.services;

import org.foobarspam.furnaceDIGuice.interfaces.Heater;
import org.foobarspam.furnaceDIGuice.types.RoomTemperature;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class GasHeater implements Heater {
	
	private RoomTemperature temperature = null;
	
	// prefiero evitar la inyeccion en propiedad de instancia por testing
	@Inject
	public void setTemperature(RoomTemperature temperature){
		this.temperature = temperature;		
	}
	
	public void engage(){
		temperature.incrementTemperature(1);
	}
	
	public void disengage(){
		temperature.incrementTemperature(-1);
	}	
}
