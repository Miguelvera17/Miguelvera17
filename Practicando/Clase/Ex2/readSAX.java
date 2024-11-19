import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class readSAX{
    
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLReader procesadorXML = parser.getXMLReader();

        GestorXML  gestor = new GestorXML();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("encargos.xml");
        procesadorXML.parse(fileXML);
    }
}

class GestorXML extends DefaultHandler{

    public GestorXML() {}

    @Override
    public void startDocument(){
        System.out.println("Inicio XML");
    }
    
    @Override
    public void endDocument() {
        System.out.println("Fin XML");
    }
    
    @Override
    public void startElement(String uri, String nom, String nomC, Attributes atts) {
        for (int i = 0; i < atts.getLength(); i++) {
            String nomAtri = atts.getQName(i);
            String value = atts.getValue(i);
            System.out.printf("\t\tAtributo: %s, Valor: %s %n", nomAtri,value);
        }
        System.out.printf("\tPrincipio del Elemento: %s %n", nomC);
    }

    @Override
    public void characters(char[] ch, int inicio, int longi) throws SAXException{
        String car = new String(ch, inicio, longi).trim();
        if(!car.isEmpty()) {
            System.out.printf("\t\tCaracteres: %s %n", car);
        }
    }
    
    @Override
    public void endElement(String uri, String nom, String nomC) {
        System.out.printf("\tFin de elemento: %s %n", nomC);
    }
}

