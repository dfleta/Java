package org.foobarspam.furnaceDIGuice.interfaces;

import org.foobarspam.furnaceDIGuice.types.RoomTemperature;

public interface Heater {
	
	public void engage(RoomTemperature temperature);
	public void disengage(RoomTemperature temperature);

}
