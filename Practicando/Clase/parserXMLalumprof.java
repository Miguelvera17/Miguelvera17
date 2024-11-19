import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class parserXMLalumprof {
    public static void main(String[] args) {
        try {
            List<String> professorIds = new ArrayList<>();
            // Parsear professores.xml
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler professorHandler = new DefaultHandler() {
                boolean isId = false;

                @Override
                public void startElement(String uri, String nom, String nomC,Attributes attrs) {
                    if (nomC.equalsIgnoreCase("id")) {
                        isId = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    if (isId) {
                        professorIds.add(new String(ch, start, length).trim());
                        isId = false;
                    }
                }
            };
            saxParser.parse(new File("professors.xml"), professorHandler);
            DefaultHandler alumneHandler = new DefaultHandler() {
                boolean isnom = false;
                boolean isIdprofessor = false;
                String currentnom = null;
                String currentIdprofessor = null;

                @Override
                public void startElement(String uri, String nom, String nomC, Attributes attrs) {
                    if (nomC.equalsIgnoreCase("nom_alumne")) {
                        isnom = true;
                    } else if (nomC.equalsIgnoreCase("id_professor")) {
                        isIdprofessor = true;
                    }
                }
                
                @Override
                public void characters(char[] ch, int start, int length) {
                    if (isnom) {
                        currentnom = new String(ch, start, length).trim();
                        isnom = false;
                    } else if (isIdprofessor) {
                        currentIdprofessor = new String(ch, start, length).trim();
                        isIdprofessor = false;
                    }
                }

                @Override
                public void endElement(String uri, String nom, String nomC) {
                    if (nomC.equalsIgnoreCase("alumne")) {
                        if (!professorIds.contains(currentIdprofessor)) {
                            System.out.println("Alumne sense professor: " + currentnom +
                                    " (id_professor: " + currentIdprofessor + ")");
                        }
                        currentnom = null;
                        currentIdprofessor = null;
                    }
                }
            };
            saxParser.parse(new File("alumnes.xml"), alumneHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}