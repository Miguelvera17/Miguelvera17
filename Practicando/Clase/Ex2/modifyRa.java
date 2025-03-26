import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class modifyRa {
    
    public static void main(String[] args) throws IOException{
        System.out.println("Indique la opción");
        System.out.println("1. Buscar un empleado");
        System.out.println("2. Modificar altura");
        BufferedReader reader = new BufferedReader ( new InputStreamReader(System.in));
        int opt = Integer.parseInt(reader.readLine());
        System.out.println("Indique el nombre del empleado");
        String nEmp = reader.readLine();
        Double alt = 0.0;
        String file = "empledos.dat";
        
        if (opt == 1) {
            String mode = "r";
            modify(mode,opt,file,alt, nEmp);
        }
        else if(opt == 2) {
            System.out.println("Indique la nueva altura");
            alt = Double.parseDouble(reader.readLine());
            String mode = "rw";
            modify(mode,opt,file,alt, nEmp);
        }
    }

    public static void modify(String mode, int opt, String file, Double alt, String nom) throws IOException{
        RandomAccessFile raf1 = new RandomAccessFile(file, mode);

        int pos = 0;

        char aux;

        char name[] = new char[20];
        int edad;
        Double altura;
        Boolean encontrado = false;

        while (raf1.getFilePointer() != raf1.length()) {
            raf1.seek(pos);
            for(int i = 0 ; i < name.length; i++) {
                aux = raf1.readChar();
                name[i] = aux;
            }

            String n = new String(name);
            edad = raf1.readInt();
            if (n.trim().equals(nom)) {
                encontrado = true;

                if (opt == 1) {
                    edad = raf1.readInt();
                    altura = raf1.readDouble();
                    System.out.printf("Nom: %s, Age: %d, Alt: %.2f %n",
                    n.trim(),edad,alt);
                }
                else if (opt == 2) {
                    raf1.writeDouble(alt);
                    
                }
            } else {
                raf1.skipBytes(8);
            }
            pos = pos + 52;
        }

        if (!encontrado) {
            System.out.println("No se encontro empleado");
        }
        raf1.close();
    }
}
