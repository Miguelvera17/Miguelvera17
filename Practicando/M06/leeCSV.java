
import java.io.*;

public class leeCSV {

    public static void main(String[] args){
        String path = args[0];
        File file = new File(path);
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(file));) {
            
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                System.out.println("IdProducte: " + datos[0]);
                System.out.println("Nom: " + datos[1]);
                System.out.println("Unitats: " + datos[2]);
                System.out.println("PreuUnitari: " + datos[3]);
                System.out.println();         
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
