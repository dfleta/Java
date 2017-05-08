package org.foobarspam.furnaceDIGuice.services;

import org.foobarspam.furnaceDIGuice.interfaces.Thermometer;
import org.foobarspam.furnaceDIGuice.types.RoomTemperature;

import com.google.inject.Singleton;

@Singleton
public class RemoteCommandSensor implements Thermometer {
	
	public double read(RoomTemperature temperature){
		return temperature.getTemperature();
	}

}
