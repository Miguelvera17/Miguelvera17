public class Taula {

    private Filosof comensals[];
    private Forquilla forquilles[];
    
    public Taula(int numfilosofs) {
        comensals = new Filosof[numfilosofs];
        forquilles = new Forquilla[numfilosofs];

        for(int i = 0; i < numfilosofs; i++) {
            comensals[i] = new Filosof(i);
            forquilles[i] = new Forquilla(i);
        }

        for(int i = 0; i < comensals.length; i++) {
            comensals[i].forquillaEsquerra = forquilles[i];
            comensals[i].forquillaDreta = (i == comensals.length-1) ? forquilles[0] : forquilles[i+1];
        }
    }
    
    public void showTaula() {
        for(int i = 0; i < comensals.length; i++) {
            System.out.printf("Comensals:%s esq:%d dret:%d%n",comensals[i].getName(),comensals[i].forquillaEsquerra.getNum(), comensals[i].forquillaDreta.getNum());
        }
    }

    public void cridarATaula() {
        for (int i = 0; i < comensals.length; i++) {
            comensals[i].start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        System.out.println("------------");
        taula.cridarATaula();
    }
}
