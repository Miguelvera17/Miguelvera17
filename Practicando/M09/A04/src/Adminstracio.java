public class Adminstracio {
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa;

    public Adminstracio() {
        poblacio_activa = new Treballador[num_poblacio_activa];

        for(int i = 0; i < poblacio_activa.length; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i,25000,20,65);
        }
    }

    public static void main(String[] args) {
        Adminstracio adm = new Adminstracio();

        for (int i = 0; i < adm.num_poblacio_activa;i++) {
            adm.poblacio_activa[i].start();
        }

        for (int i = 0; i < adm.num_poblacio_activa; i++) {
            try{
                adm.poblacio_activa[i].join();
            } catch (InterruptedException e) {
                System.err.println("Despertat");
            }
        }

        for (int i = 0; i < adm.num_poblacio_activa; i++) {
            System.out.printf("%-10s -> edat: %2d / total: %6.2f%n",
            adm.poblacio_activa[i].getName(),
            adm.poblacio_activa[i].getEdat(),
            adm.poblacio_activa[i].getCobrat());
        }
    }
}