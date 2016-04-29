
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:02:19 GMT)
 */

        
            package mobi.mobipalma.api.docs;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "https://api.mobipalma.mobi/docs/".equals(namespaceURI) &&
                  "Bicicleta".equals(typeName)){
                   
                            return  mobi.mobipalma.api.docs.Bicicleta.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://api.mobipalma.mobi/docs/".equals(namespaceURI) &&
                  "Estacion".equals(typeName)){
                   
                            return  mobi.mobipalma.api.docs.Estacion.Factory.parse(reader);
                        

                  }

              
                  if (
                  "https://api.mobipalma.mobi/docs/".equals(namespaceURI) &&
                  "Anclajes".equals(typeName)){
                   
                            return  mobi.mobipalma.api.docs.Anclajes.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    