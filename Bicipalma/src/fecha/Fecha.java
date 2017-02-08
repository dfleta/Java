package fecha;

import java.time.*;
import static java.time.temporal.ChronoUnit.MINUTES;

public class Fecha {

	public static void main(String[] args) {
	

		LocalTime horaRetirada = LocalTime.of(15, 30);
		LocalTime horaDevolucion = LocalTime.of(16, 40);
				
		LocalDateTime dateTime = LocalDateTime.now();
		
		System.out.println("hora retirada: " + horaRetirada);
		System.out.println("hora devolucion: " + horaDevolucion);
		
		System.out.println(dateTime);
		
		long minutes = MINUTES.between(horaRetirada, horaDevolucion);
		
		System.out.println("Using between (minutes): " + minutes);
		

	}

}
