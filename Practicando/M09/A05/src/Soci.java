import java.util.Random;

public class Soci extends Thread{
    
    private static Compte compte;
    public static final float aportacio = 10f;
    private static final int esperaMax= 100;
    private Random random;
    private int maxAnys = 10;

    public Soci(String nom) {
        super(nom);

        compte = Compte.getInstancia();
        random = new Random();
    }

    public static Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {

        for(int i = 0; i < maxAnys; i++) {
            for (int j = 0; j < 12; j++) {
                if (j % 2 == 0) {
                    synchronized(compte) {
                        float balanc = compte.getSaldo() + aportacio;
                        compte.setSaldo(balanc);
                    }
                } else {
                    synchronized(compte) {
                        float balanc = compte.getSaldo() - aportacio;
                        compte.setSaldo(balanc);
                    }
                }
                try {
                    sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    System.err.println("Interromput");
                }
            }
        }
    }
}
