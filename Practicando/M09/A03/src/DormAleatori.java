import java.util.Random;

public class DormAleatori extends Thread{

    private long tempsDinici = 0;

    public DormAleatori(String nom) {
        super(nom);
        this.tempsDinici = System.currentTimeMillis();
    }
    
    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            long tempsAleatori = random.nextLong(1000);
            long tempsTotal = System.currentTimeMillis() - tempsDinici;

            System.out.printf("%-4s(%d) a dormir %4dms total %5d%n",getName(),i,tempsAleatori,tempsTotal);
            try{
                Thread.sleep(tempsAleatori);
            } catch (InterruptedException e) {
                System.out.println("Interromput");
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori da1 = new DormAleatori("Joan");
        DormAleatori da2 = new DormAleatori("Pep");
        da1.start();
        da2.start();

        System.out.println("-------Fi de main-------");
    }
}
