import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    
    private List<Assistent> assistents;
    private int placesMax = 10;

    public Esdeveniment(int placesMax) {
        assistents = new ArrayList<>();
        this.placesMax = placesMax;
    }

    public synchronized void ferReserva(Assistent assistent) throws InterruptedException {
        while(placesMax == 0) {
            wait();
        }
        assistents.add(assistent);
        placesMax--;

        System.out.println(Thread.currentThread().getName() + 
        " ha fet una reserva. Places disponibles: " + placesMax);
    }

    public synchronized void cancelarReserva(Assistent assistent) {
        if(assistents.remove(assistent)) {
            placesMax++;
            System.out.println(Thread.currentThread().getName() + 
            " ha cancel·lat una reserva. Places disponibles: " + placesMax);
        } else {
            System.out.println(Thread.currentThread().getName() + 
            " no ha pogut cancel·lat una reserva inexistent. Places disponibles: " + placesMax);
        }

        notifyAll();
    }
}
