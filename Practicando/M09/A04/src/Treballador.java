import java.util.Random;

public class Treballador extends Thread{
    
    private float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random random;

    public Treballador(String nom, float sou_anual_brut, int edat_inici_treball, int edat_fi_treball) {
        super(nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        random = new Random();
    }

    public void cobra() {
        cobrat += sou_anual_brut/12;
    }

    public void pagaImpostos() {
        cobrat -= ((sou_anual_brut/12) * 0.24);
    }

    @Override
    public void run() {
        try {
            for (edat_actual = edat_inici_treball;
            edat_actual < edat_fi_treball;
            edat_actual++) {
                for (int i = 0; i < 12; i++) {
                    sleep(random.nextInt(10));
                    cobra();
                    sleep(random.nextInt(10));
                    pagaImpostos();
                }
            }
        } catch(InterruptedException e) {
            System.err.println("Despertat");
        }
    }

    public float getCobrat() {
        return this.cobrat;
    }

    public int getEdat() {
        return this.edat_actual;
    }
}
