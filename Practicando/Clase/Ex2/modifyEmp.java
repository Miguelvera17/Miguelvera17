import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class modifyEmp {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        System.out.println("Indique la opcion a realizar");
        System.out.println("1. Buscar empleado");
        System.out.println("2. Modificar edad");
        int opt = Integer.parseInt(reader.readLine());
        System.out.print("Introduzca el nombre a buscar: ");
        String nom = reader.readLine();
        int age;
        String file = "empledos.dat";
        if (opt == 1) {
            age = 0;
            modify("r",nom,age , file, opt);
        }
        else if (opt == 2 ) {
            System.out.print("Indique la nueva edad: ");
            age = Integer.parseInt(reader.readLine());
            modify ("rw", nom, age , file, opt);
        }
        else {
            System.out.println("Error");
            reader.close();
        }
    }

    public static void modify(String mode, String nom, int age, String file, int opt) throws IOException{
        RandomAccessFile raf1 = new RandomAccessFile(file, mode);
        int pos = 0;

        char aux;
        char name[] = new char[20];
        int edat;
        Double alt;
        boolean busca = false;

        while (raf1.getFilePointer() != raf1.length()) {
            raf1.seek(pos);
            for (int i = 0; i < name.length; i++) {
                aux = raf1.readChar();
                name[i] = aux;
            }
            String n = new String(name);
            if (n.trim().equals(nom)) {
                busca = true;

                if (opt == 1) {
                    edat = raf1.readInt();
                    alt = raf1.readDouble();
                    System.out.printf("Nom: %s, Age: %d, Alt: %.2f %n",
                    n.trim(),edat,alt);
                } else if (opt == 2) {
                    raf1.writeInt(age);
                    
                    raf1.skipBytes(8);
                }
            } else {
                raf1.skipBytes(12);
            }
            pos = pos + 52;
        }
        if (!busca) {
            System.out.println("Empleado no encontrado");
        }
        raf1.close();
    }
}
