import java.io.IOException;
import java.io.RandomAccessFile;

public class writeAleatori {
    
    public static void main(String[] args) throws IOException{
        RandomAccessFile raf1 = new RandomAccessFile("empledos.dat", "rw");

        String[] nom = {"Miguel", "Angel", "Mirella"};
        int[] age = {30,27,20};
        Double[] alt = {1.84, 1.83, 1.70};

        StringBuffer sbf = null;

        for(int i = 0; i < nom.length; i++) {
            sbf = new StringBuffer(nom[i]);
            sbf.setLength(20);
            raf1.writeChars(sbf.toString());

            raf1.writeInt(age[i]);
            raf1.writeDouble(alt[i]);
        }
        raf1.close();
    }
}
