import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LlegirAleatori {

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        
        RandomAccessFile raf1 = new RandomAccessFile("Empleats.dat", "r");

        //Declarem la variable que ens permetrà posicionar-nos al fitxer
        int posicio=0; 

        //Declarem la variable auxiliar que emmagatzemarà cada caràcter
        //de l'array de caràcters del nom
        char aux;

        //Declarem les variables dels camps que anem a llegir
        char nomEmpleat[] = new char[20];
        int departament;
        double salari;

        //condició d'iteració: fins a la longitud màxima de fitxer
        while(raf1.getFilePointer() != raf1.length()){
            
            //ens posicionem d'acord al valor de la variable posició
            raf1.seek(posicio);

            //iterem caràcter a caràcter i els anem ficant a nomEmpleat
            for (int i=0;i<nomEmpleat.length;i++) {
                aux = raf1.readChar();
                nomEmpleat[i] = aux;
            }

            //Reconstruïm en un únic String
            String nomCompletEmpleat = new String(nomEmpleat);
            departament = raf1.readInt();
            salari = raf1.readDouble();

            //Si el fitxer no està buit i s'ha llegit informació, fem el printf
            if (!(nomCompletEmpleat.isEmpty())) {
                System.out.printf("Nom empleat: %s, Departament: %d, Salari: %.2f %n",
                nomCompletEmpleat.trim(),departament,salari);

                //reposicionem per anar al següent registre
                posicio = posicio + 52;
            }
        }
        raf1.close();
    }
}