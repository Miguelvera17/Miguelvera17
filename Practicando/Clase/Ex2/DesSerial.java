import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DesSerial {
    public static void main(String[] args) {
        ObjectInputStream deserializador = null;

        try {
            deserializador = new ObjectInputStream( new FileInputStream ("ProdSer.dat"));
            Productes[] listaProductes = (Productes[])deserializador.readObject();
            for (Productes p : listaProductes) {
                System.out.println(p);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) { 
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }    
}
