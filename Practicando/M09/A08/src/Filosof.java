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
            
            while(!agafarForquillesEsquerra()) {
                System.out.printf("%s espera forquilla esq en mans de:%d%n",getName(),forquillaEsquerra.getPropietari());
                deixarForquilles();
                try{
                    wait();
                } catch(InterruptedException e) {
                    System.out.println("Filòsof interromput");
                }
            }
        }
    }
}
