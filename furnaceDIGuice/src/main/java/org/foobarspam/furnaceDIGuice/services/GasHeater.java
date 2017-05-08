package org.foobarspam.furnaceDIGuice.services;

import org.foobarspam.furnaceDIGuice.interfaces.Heater;
import org.foobarspam.furnaceDIGuice.types.RoomTemperature;

import com.google.inject.Singleton;

@Singleton
public class GasHeater implements Heater {
	
	public void engage(RoomTemperature temperature){
		temperature.incrementTemperature(1);
	}
	
	public void disengage(RoomTemperature temperature){
		temperature.incrementTemperature(-1);
	}
}
