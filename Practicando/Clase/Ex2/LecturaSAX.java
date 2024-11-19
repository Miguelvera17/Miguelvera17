import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class LecturaSAX {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        System.out.print("Indica el nombre del archivo XML: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        System.out.print("Indica el nombre del cliente: ");
        String client = reader.readLine();

        SAXParserFactory saxpf = SAXParserFactory.newInstance();
        SAXParser parser = saxpf.newSAXParser();
        XMLReader procesadorXML = parser.getXMLReader();

        // Pasar el cliente como parámetro al gestor de contenido
        GestioContingut gestor = new GestioContingut(client);
        procesadorXML.setContentHandler(gestor);

        InputSource fileXML = new InputSource(file);
        procesadorXML.parse(fileXML);
    }
}

// Gestor de contenido que filtra por cliente
class GestioContingut extends DefaultHandler {
    private String client; // Cliente que queremos filtrar
    private boolean isTargetClient = false; // Bandera para indicar si estamos procesando el encargo del cliente deseado
    private boolean insideEncargo = false; // Bandera para indicar si estamos dentro de un <encarrec>
    private String currentElement = ""; // Elemento actual que se está procesando

    public GestioContingut(String client) {
        super();
        this.client = client;
    }

    // Anunciar el inicio del documento
    public void startDocument() {
        System.out.println("Iniciando procesamiento del documento XML...");
    }

    // Anunciar el final del documento
    public void endDocument() {
        System.out.println("Final del procesamiento del documento XML.");
    }

    // Comenzar a procesar los elementos
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;

        // Detectar inicio de un <encarrec>
        if (qName.equalsIgnoreCase("encarrec")) {
            insideEncargo = true;
            isTargetClient = false; // Reiniciar la bandera para cada nuevo encargo
        }
    }

    // Procesar el texto dentro de los elementos
    public void characters(char[] ch, int start, int length) {
        if (insideEncargo) {
            String value = new String(ch, start, length).trim();

            // Si estamos leyendo el cliente y coincide con el deseado, marcar como objetivo
            if (currentElement.equalsIgnoreCase("clientName") && value.equalsIgnoreCase(client)) {
                isTargetClient = true;
            }

            // Si el encargo es del cliente objetivo, imprimir el contenido
            if (isTargetClient && !value.isEmpty()) {
                System.out.printf("\tPrincipi Element: %s %n", currentElement);
                System.out.printf("\tCharacter: %s %n", value);
            }
        }
    }

    // Finalizar el procesamiento de elementos
    public void endElement(String uri, String localName, String qName) {
        // Detectar el fin de un <encarrec>
        if (qName.equalsIgnoreCase("encarrec")) {
            // Solo imprimir cuando es el encargo de nuestro cliente objetivo
            if (isTargetClient) {
                System.out.println("\nFin del encargo para el cliente: " + client);             
            }
            insideEncargo = false;
            isTargetClient = false; // Reiniciar la bandera al salir del encargo
        }
        
    }
}
