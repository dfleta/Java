
/* Clase JAXB e interfaz Marshaller explicadas en:
 * https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/package-summary.html
 * */

package jaxbClases;

import jaxbClases.ObjectFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bicicleta.Bicicleta;

public class XMLaObjeto {

	public static void main(String[] args) {
		
		try {
			/* 1 - JAXB CONTEXT
			 * https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/JAXBContext.html
			 * The JAXBContext class provides the client's entry point to the JAXB API. 
			 * It provides an abstraction for managing the XML/Java binding information necessary
			 * to implement the JAXB binding framework operations: unmarshal, marshal and validate.
			 * The JAXBContext object allows the merging of global elements and type definitions across
			 * a set of schemas (listed in the contextPath). 
			 * */
			
			// A JAXBContext instance is created for handling classes
			// https://docs.oracle.com/javaee/5/tutorial/doc/bnbay.html
			// el nombre de la clase ha de resultar de la forma: com.acme.foo.Foo.class => .class.getPackage().getName()
			
			JAXBContext jc = JAXBContext.newInstance(Estacion.class.getPackage().getName());
			
			/* 2 - UNMARSHALLER
			 * https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/JAXBContext.html
			 * https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/Unmarshaller.html
			 * The Unmarshaller class provides the client application the ability to convert XML data
			 * into a tree of Java content objects. 
			 * The unmarshal method allows for any global XML element declared in the schema to be unmarshalled
			 * as the root of an instance document.
			 * A client application is able to unmarshal XML documents that are instances of any of the schemas
			 * listed in the contextPath. 
			 * Unmarshalling can deserialize XML data that represents either an entire XML document or 
			 * a subtree of an XML document. Typically, it is sufficient to use the unmarshalling methods described 
			 * by Unmarshal root element that is declared globally. These unmarshal methods utilize JAXBContext's 
			 * mapping of global XML element declarations and type definitions to JAXB mapped classes to initiate 
			 * the unmarshalling of the root element of XML data.
			 * The JAXBContext instance is the one that was used to create this Unmarshaller. The JAXBContext 
			 * instance maintains a mapping of globally declared XML element and type definition names to JAXB mapped classes.
			 */
			
			// An Unmarshaller instance is created, and estacion.xml is unmarshalled.
			
			Unmarshaller u = jc.createUnmarshaller();
			InputStream in = new FileInputStream("src/estacion.xml");
			JAXBElement<Estacion> objetoEstacion = (JAXBElement<Estacion>)u.unmarshal(in);

			/* JAXBElement<Element> JAXB representation of an Xml Element.
			 * This class represents information about an Xml Element from both the element declaration 
			 * within a schema and the element instance value within an xml document
			 * */
			

			// Estacion estacion = (Estacion)u.unmarshal(in);
			System.out.println(objetoEstacion.getName() + " : ");
			// value represents the element instance's atttribute(s) and content model
			System.out.println("Estacion: " + objetoEstacion.getValue().getId());
			System.out.println("Direccion: " + objetoEstacion.getValue().getDireccion());
			System.out.println("Numero de anclajes: " + objetoEstacion.getValue().getNumeroAnclajes());
			
			/* Visualizar bicis y anclajes */
			System.out.println("Bicis y anclajes:");
			consultarAnclajes(objetoEstacion);
			
			
			// for( String anclaje:objetoEstacion.getValue().getAnclajes().getConexion();   )
			
			
			/* De otro modo
			 * */
			// Estacion objetoEstacion = (Estacion)u.unmarshal( new FileInputStream( "src/estacion.xml" ) );
			// System.out.println("Estacion: " + objetoEstacion.getId());
			
			
			/* MARSHALLER
			 * https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/Marshaller.html
			 * https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/JAXBContext.html
			 * The Marshaller class provides the client application the ability to convert
			 * a Java content tree back into XML data. There is no difference between marshalling 
			 * a content tree that is created manually using the factory methods and marshalling 
			 * a content tree that is the result an unmarshal operation.
			 * */
			
			// Marshalling to a java.io.OutputStream:
			System.out.println("Objeto en memoria marshalled a XML: ");
			Marshaller m = jc.createMarshaller(); 			
			m.marshal( objetoEstacion, System.out );
			
			// Marshalling to a File:
			OutputStream fichero = new FileOutputStream( "src/marshalizado.xml" );
			m.marshal( objetoEstacion, fichero );
			
		} 
		catch (JAXBException | IOException ex) {
			ex.printStackTrace();
		}

	}
	
	public static void consultarAnclajes(JAXBElement<Estacion> objetoEstacion){
		// recorre el array anclajes y muestra el id de la bici anclada o si está libre
		
		int posicion = 0;
		int numeroAnclaje = 0;
		
		for(String anclaje:objetoEstacion.getValue().getAnclajes().getConexion() ){
			numeroAnclaje = posicion + 1;
			if( anclaje != null ){
				System.out.println("Anclaje " + numeroAnclaje + " " + anclaje);
			}
			else
				System.out.println("Anclaje " + numeroAnclaje + " " + " libre");
			
			posicion++;	
		}
	}

}
