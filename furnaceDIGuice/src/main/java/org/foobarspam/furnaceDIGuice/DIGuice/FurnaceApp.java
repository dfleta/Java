package org.foobarspam.furnaceDIGuice.DIGuice;

import org.foobarspam.furnaceDIGuice.consumer.Regulador;
import org.foobarspam.furnaceDIGuice.injector.RegulatorModule;
import org.foobarspam.furnaceDIGuice.services.Jedi;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class FurnaceApp {
	
    public static void main( String[] args ) {
    	
    	final double minTemp = 15.0;
        final double maxTemp = 21.0;
        // Movemos la creacion e inicializacion del objeto RoomTemperature al module del inyector
        // RoomTemperature temperature = new RoomTemperature(15);

        /*
         *  Guice.createInjector() takes your Modules, 
         *  and returns a new Injector instance.
         */
        Injector injector = Guice.createInjector(new RegulatorModule());		
		
        /*
         * Now that we've got the injector, we can build objects.
         * El codigo equivalente es:
         * Heater heater = new GasHeater();
         * Thermometer thermometer = new RemoteCommandSensor();
         * Regulador regulator = new Regulador(Thermometer, GasHeater);
         */ 
		Regulador regulador = injector.getInstance(Regulador.class);
		
		regulador.setMinTemp(minTemp);
		regulador.setMaxTemp(maxTemp);
		// movemos la configuracion del objeto RoomTemperature al module del inyector
		// mediante un metodo @Provides
		// regulador.setTemperature(15);
		
        System.out.println( "Arrancando..." );
        
		regulador.regulate();        
        
        ((Jedi) regulador.getHeater()).speak();
        
    }
}
