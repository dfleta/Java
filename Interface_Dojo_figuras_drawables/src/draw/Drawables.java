package draw;

import java.util.ArrayList;

public class Drawables {
	
	public static void dibujarDrawables(ArrayList<Drawable> lista){
		
		for(Drawable objeto: lista){
			objeto.draw();
		}
		
	}
}
