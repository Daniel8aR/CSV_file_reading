package org.smartkode.xml_work;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class xml_extraction {
    private static String getValueTag(String tagName, Element element) {
        String res = "";
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                res = subList.item(0).getNodeValue();
            }
        }

        if(res.equals("")){
            res = "Etiqueta no encontrada";
        }

        return res;
    }

    public static void main(String []args){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<resultado>\n" +
                "    <codigo>10</codigo>\n" +
                "    <mensaje>Prueba XML1</mensaje>\n" +
                "    <rfc>123456nhugytrt3456</rfc>\n" +
                "</resultado>"
                ;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));
            Element formato = document.getDocumentElement();

            System.out.println(document);

            String codigo = getValueTag("codigo",formato);
            String mensaje = getValueTag("mensaje",formato);
            String rfc = getValueTag("rfc",formato);

            System.out.println("Código: " + codigo);
            System.out.println("Mensaje: " + mensaje);
            System.out.println("Mensaje: " + rfc);

        } catch (Exception e){
            System.out.println("Error: " + e);
        }

    }
}
