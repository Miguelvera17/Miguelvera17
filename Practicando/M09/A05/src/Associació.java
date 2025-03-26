public class Associació {
    
    private static final int numSocis = 100;
    private Soci socis[];

    public Associació() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci(String.format("Soci%2d", i));
        }
    }

    public void iniciaCompteTempsSocis() {
        for (Soci soci : socis) {
            soci.start();
        }
    }

    public void esperaPeriodeSocis() {
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                System.err.println("Interromput");
            }
        }
    }

    public void mostraBalancComptes() {
        System.out.printf("Saldo: %2.2f%n",Soci.getCompte().getSaldo());
    }

    public static void main(String[] args) {
        Associació asoc = new Associació();
        asoc.iniciaCompteTempsSocis();
        asoc.esperaPeriodeSocis();
        asoc.mostraBalancComptes();
    }
}
