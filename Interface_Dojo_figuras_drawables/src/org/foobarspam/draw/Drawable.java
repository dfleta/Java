package org.foobarspam.draw;

public interface Drawable {
	
	void draw();
	
	default void applyTheme(){
		throw new UnsupportedOperationException("Operacion applyTheme sin implementar");
	}

}
