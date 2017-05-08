package org.foobarspam.furnaceDIGuice.injector;

import org.foobarspam.furnaceDIGuice.interfaces.Heater;
import org.foobarspam.furnaceDIGuice.interfaces.Thermometer;
import org.foobarspam.furnaceDIGuice.services.GasHeater;
import org.foobarspam.furnaceDIGuice.services.Jedi;
import org.foobarspam.furnaceDIGuice.services.RemoteCommandSensor;
import org.foobarspam.furnaceDIGuice.types.RoomTemperature;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class RegulatorModule extends AbstractModule {

	@Override
	protected void configure() {
		//bind the service to implementation class
		bind(Heater.class).to(GasHeater.class);
		// para seleccionar el tipo de servicio mediante BindingAnnotation:
		bind(Heater.class).annotatedWith(Force.class).to(Jedi.class);
		
		bind(Thermometer.class).to(RemoteCommandSensor.class);
		
		/* 
		 * dependencia a una clase concreta
		 * You can bind a type to a specific instance of that type. 
		 * This is usually only useful only for objects that 
		 * don't have dependencies of their own, such as value objects.	
		 * 
		 * Otra manera de hacerlo: con @Provides:
		 * construir un objeto concreto manualmente 
		 */

		// bind(RoomTemperature.class);
	}
	
	/*
	 * When you need code to create an object, use an @Provides method. 
	 * The method must be defined within a module, and it must have an @Provides annotation. 
	 * The method's return type is the bound type. 
	 * Whenever the injector needs an instance of that type, it will invoke the method.
	 */
	@Provides
	RoomTemperature provideRoomTemperature() {
		RoomTemperature roomTemperature = new RoomTemperature();
		// movemos la configuracion del objeto desde el main a este modulo
	    roomTemperature.setTemperature(15);
	    return roomTemperature;
	  }

}
