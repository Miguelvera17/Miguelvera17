import java.io.*;


    public class modificaEmpleat {

        public static void main(String[] args) throws IOException, FileNotFoundException {
            BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
            RandomAccessFile raf1 = new RandomAccessFile("Empleats.dat", "rw");
    
    
            //Declarem la variable que ens permetrà posicionar-nos al fitxer
            int posicio=0; 
    
            //Declarem la variable auxiliar que emmagatzemarà cada caràcter
            //de l'array de caràcters del nom
            char aux;
    
            //Declarem les variables dels camps que anem a llegir
            char nomEmpleat[] = new char[20];
            System.out.print("Ingrese nombre del empleado a buscar: ");
            String empleado = line.readLine();
            //condició d'iteració: fins a la longitud màxima de fitxer
            while(raf1.getFilePointer() != raf1.length()) {
    
                //ens posicionem d'acord al valor de la variable posició
                raf1.seek(posicio);
    
                //iterem caràcter a caràcter i els anem ficant a nomEmpleat
                for (int i=0;i<nomEmpleat.length;i++) {
                    aux = raf1.readChar();
                    nomEmpleat[i] = aux;
                }
    
                //Reconstruïm en un únic String
                String nomCompletEmpleat = new String(nomEmpleat);
    
                //Si el fitxer no està buit i s'ha llegit informació, fem el printf
                if (!(nomCompletEmpleat.isEmpty())) {
                    if (nomCompletEmpleat.contains(empleado)) {
                        System.out.print("Ingrese el nuevo departamento ");
                        int depart = Integer.parseInt(line.readLine());
                        raf1.seek(posicio + 40);
                        raf1.writeInt(depart);
                        System.out.println("Departamento modificado");
                        break;
                    }
                    //reposicionem per anar al següent registre
                    if (posicio == raf1.length()) {
                        System.out.println(raf1.length());
                        break;
                    }
                    posicio = posicio + 52;
                    
                }   
            }
            raf1.close();
        }
    
}
