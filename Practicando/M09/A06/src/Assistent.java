public class Assistent extends Thread{
    
    private Esdeveniment esdeveniment;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    public void run() {

        try {
            while(true) {
                if(Math.random() > 0.3) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelarReserva(this);
                }
                sleep((long)(Math.random() * 1000));
            } 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
