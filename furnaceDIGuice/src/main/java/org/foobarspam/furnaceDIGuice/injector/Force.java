package org.foobarspam.furnaceDIGuice.injector;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import com.google.inject.BindingAnnotation;

/* 
 * Necesito esta interfaz para crear la BindingAnnotation
 * que me permita seleccionar que implementacion del servicio
 * quiero utilizar.
 * Explicacion @Target y @Retention:
 * https://github.com/google/guice/wiki/BindingAnnotations
 */

@BindingAnnotation 
@Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
public @interface Force {
}
