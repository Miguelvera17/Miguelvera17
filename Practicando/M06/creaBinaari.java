import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class creaBinaari {
    public static void main(String[] args) {
        String path = args[0];
        String f1 = "C:\\Users\\migue\\Desktop\\DAM2\\M06\\Miguelvera17\\Practicando\\M06"+ "_" + System.currentTimeMillis() + ".dat";
        File file = new File(path);
        File file1 = new File(f1);
        String line;
        String a = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(file));) {
            FileOutputStream filename = new FileOutputStream(file1);
            DataOutputStream writer = new DataOutputStream(filename);
            String top = reader.readLine();
            writer.writeUTF(top);
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                System.out.println("IdProducte: " + datos[0]);
                System.out.println("Nom: " + datos[1]);
                System.out.println("Unitats: " + datos[2]);
                System.out.println("PreuUnitari: " + datos[3]);
                System.out.println();
                a = a + line;       
            }
            writer.writeUTF(a);
            writer.close();
            filename.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
