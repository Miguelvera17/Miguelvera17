public class Filosof extends Thread{
    
    public Forquilla forquillaEsquerra;
    public Forquilla forquillaDreta;
    public int gana = 0;
    public int numComensal;
    
    public Filosof(int num) {
        super("Fil" + num);
        numComensal = num;
        gana = 0;
    }

    public synchronized void agafarForquilles() {
        do {
            System.out.printf("%s intenta agafar forquilla esquerra%n",getName());
            
            while(!agafarForquillaEsquerra()) {
                System.out.printf("%s espera forquilla esq en mans de:%d%n",getName(),forquillaEsquerra.getPropietari());
                deixarForquilles();
                try{
                    wait();
                } catch(InterruptedException e) {
                    System.out.println("Filòsof interromput");
                }
            }

            while(!agafarForquillaDreta()) {
                deixarForquilles();
                System.out.printf("%s espera forquilla dreta i espera%n",getName());
                try{
                    wait();
                } catch(InterruptedException e) {
                    System.out.println("Filòsof interromput");
                }
                System.out.printf("%s agafa la forquilla dreta%n",getName());
            }
        }
        while(forquillaEsquerra.getPropietari() != numComensal && forquillaDreta.getPropietari() != numComensal);

        System.out.printf("%s té forquilles esq(%d) dreta(%d) i gana:%d%n",getName(),forquillaEsquerra.getNum(),forquillaDreta.getNum(),gana);
    }

    public boolean agafarForquillaEsquerra() {
        if(forquillaEsquerra.getPropietari() != Forquilla.LLIURE) {
            return false;
        } else {
            forquillaEsquerra.setPropietari(numComensal);
            return true;
        }
    }

    public boolean agafarForquillaDreta() {
        if(forquillaDreta.getPropietari() != Forquilla.LLIURE) {
            return false;
        } else {
            forquillaDreta.setPropietari(numComensal);
            return true;
        }
    }

    public synchronized void deixarForquilles() {
        if(forquillaDreta.getPropietari() == numComensal) {
            forquillaDreta.setPropietari(Forquilla.LLIURE);
        }
        notifyAll();
        if(forquillaEsquerra.getPropietari() == numComensal) {
            forquillaEsquerra.setPropietari(Forquilla.LLIURE);
        }
        notifyAll();
    }

    public void menjar() {
        agafarForquilles();
        System.out.printf("%s menja%n",getName());
        try {
            sleep((long)(1000 + (Math.random() * 1000)));
        } catch (InterruptedException e) {
            System.out.println("Filòsof interromput");
        }
        System.out.printf("%s ha acabat de menjar%n",getName());
        deixarForquilles();
    }

    public void pensar() {
        try{
            System.out.printf("%s pensant%n",getName());
            sleep((long)(2000 + Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println("Filòsof interromput");
        }
    }

    public void run() {
        while(true) {
            menjar();
            pensar();
        }
    }
}
