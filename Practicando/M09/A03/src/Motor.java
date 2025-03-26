import java.util.Random;

public class Motor extends Thread{
    
    private int potencia = 0;
    private int potenciaActual = 0;
    private boolean apagado = true;
    private Random random;

    public Motor(String nom) {
        super(nom);
        random = new Random();
    }

    @Override
    public void run() {
        while(true) {
            while(potenciaActual != potencia) {
                potenciaActual += (potenciaActual > potencia) ? -1:1;
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    System.err.println("Interromput");
                }
                String accio = (potenciaActual > potencia) ? "Decre." : (potenciaActual == potencia) ? "FesRes" : "Incre.";
                System.out.printf("%7s: %s Objectiu:%2d Actual:%2d%n",getName(),accio,potencia,potenciaActual);
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Interromput");
            }
            if(!apagado && potenciaActual == 0) break;
        }
    }

    public void setPotencia(int p) {
        apagado = false;
        potencia = p;
    }
}
