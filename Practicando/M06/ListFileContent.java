import java.io.*;

public class ListFileContent {
    public static void main(String[] args) throws IOException{
        File folder = new File ("C:\\Users\\migue\\Documents\\MediaTIC\\Practicando\\M06");
        String filename = "C:\\Users\\migue\\Documents\\MediaTIC\\Practicando\\M06\\" + System.currentTimeMillis()+".txt";
        File f1 = new File(filename);
        String a = "";
        String b = "";
        try(BufferedWriter line = new BufferedWriter(new FileWriter(f1))) {
            if (folder.isDirectory()) {
                File[] files = folder.listFiles();
                System.out.println("Contingut de la carpeta:");
                
                for ( File file : files ) {
                    if (file.isDirectory()) {
                        System.out.print("Carpeta: ");
                        
                        System.out.println(file.getName());
                        a = a + file.getName() + "\n";
                    }
                }
                for ( File file : files ) {
                    if (file.isFile()) {
                        System.out.print("File: ");
                        
                        System.out.println(file.getName());
                        b = b + file.getName() + "\n";  
                    }
                }
            } else {
            System.out.println("La ruta especificada no és un directori.");
            }
            line.write("Carpetas");
            line.write("\n");
            line.write(a);
            line.write("Files");
            line.write("\n");
            line.write(b);
            line.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
}

