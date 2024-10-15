import java.io.*;

public class creaCSV {
    
    public static void main(String[] args) throws IOException{
        String file = args[0];
        String file2 = "C:\\Users\\migue\\Desktop\\DAM2\\M06\\Miguelvera17\\Practicando\\M06\\" + System.currentTimeMillis() + ".csv";
        File f1 = new File (file);
        File f2 = new File (file2);
        String a = "";
        try (BufferedReader line = new BufferedReader(new FileReader(f1))) {
            BufferedWriter linea = new BufferedWriter(new FileWriter(f2));
            while ((a = line.readLine()) != null) {
                linea.write(a + ",");
            }
            
            
            line.close();
            linea.close();
        } catch (FileNotFoundException e) {
            System.out.println("Path error");
        }
    }
}
