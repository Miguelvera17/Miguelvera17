import java.io.*;

public class creaCSV {
    
    public static void main(String[] args) throws IOException{
        String[] names = {"Miguel","Mirella","Kyra"};
        String file = "C:\\Users\\migue\\Documents\\MediaTIC\\Practicando\\M06\\" + System.currentTimeMillis() + ".csv";
        File f1 = new File (file);
        String a = "";
        try (BufferedWriter line = new BufferedWriter(new FileWriter(f1))) {
            for (int  i = 0; i < names.length; i++) {
                if (i == 0) {
                    a = a + names[i];
                } else {
                    a = a + "," + names[i];
                }
            }
            line.write(a);
            line.close();
        } catch (FileNotFoundException e) {
            System.out.println("Path error");
        }
    }
}
