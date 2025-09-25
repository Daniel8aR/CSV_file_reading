package org.smartkode.xml_work;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class xml_ejemplo {
    public static void main(String []args){
        InputStream xml = xml_ejemplo.class.getResourceAsStream("/xml_files/cfdv40-min.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xml);
            Element format = doc.getDocumentElement();
            System.out.println(doc);

            // --- EXTRAER DATOS ---
            // Fecha está como atributo del comprobante
            String fecha = format.getAttribute("Fecha");

            // Emisor (usa namespace)
            Element emisor = (Element) doc.getElementsByTagNameNS(
                    "http://www.sat.gob.mx/cfd/4", "Emisor").item(0);
            String rfcEmisor = emisor.getAttribute("Rfc");

            // Receptor
            Element receptor = (Element) doc.getElementsByTagNameNS(
                    "http://www.sat.gob.mx/cfd/4", "Receptor").item(0);
            String rfcReceptor = receptor.getAttribute("Rfc");


            // --- MOSTRAR RESULTADOS ---
            System.out.println("Fecha: " + fecha);
            System.out.println("RFC Emisor: " + rfcEmisor);
            System.out.println("RFC Receptor: " + rfcReceptor);
        } catch (Exception e){
            System.out.println("Error: " + e);
        }

    }
}
