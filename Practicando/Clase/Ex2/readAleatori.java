import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class readAleatori {
    
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("empledos.dat", "r");

        int pos =0;

        char aux;
        char nom[] = new char[20];
        int age;
        Double alt;

        while (raf1.getFilePointer() != raf1.length()) {
            raf1.seek(pos);
            for (int i = 0; i < nom.length; i++) {
                aux = raf1.readChar();
                nom[i] = aux;
            }
            String n = new String(nom);
            age = raf1.readInt();
            alt = raf1.readDouble();

            if (!n.isEmpty()) {
                System.out.printf("Nom: %S Age: %d Alt: %.2f%n", n.trim(),age,alt);
                pos = pos + 52;
            }
        }
        raf1.close();
    }
}
