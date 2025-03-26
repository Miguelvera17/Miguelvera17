import java.util.Random;

public class Futbolista extends Thread {

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;
    public int ngols;
    public int ntirades;

    public Futbolista(String nom) {
        super(nom);
        ngols = 0;
        ntirades = 0;
    }

    public void run() {
        Random random = new Random();
        for(int i = 0; i < NUM_TIRADES; i++){
            ntirades++;
            if(random.nextFloat() > PROBABILITAT) ngols++;
        }   
    }

    public static void main(String[] args) {
        Futbolista equip[] = new Futbolista[NUM_JUGADORS];
        String noms[] = {"Piqué","Vinicius","Torres","Ramos","Ronaldo","Lewan","Belli","Arnau","Aspas","Messi","MBappé"};
        for(int i = 0; i < NUM_JUGADORS; i++) {
            equip[i] = new Futbolista(noms[i]);
        }
    

        System.out.println("Inici dels xuts-------------");
        for (Futbolista f:equip) {
            f.start();
        }

        for (Futbolista f : equip) {
            try{
                f.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }   
        }

        System.out.println("Fi del xuts-------------------");

        System.out.println("Estadistiques-----------------");
        for(Futbolista f :equip){
            System.out.printf("%-9s -> %2d gols%n",f.getName(),f.ngols);
        }
    }
}