import java.util.Scanner;

public class Coet {
    
    public int numMotors = 4;
    public Motor[] motors;

    public Coet() {
        motors = new Motor[numMotors];
        for (int i = 0; i < numMotors; i++) {
            motors[i] = new Motor("Motor " + i);
        }
    }

    public void passaPotencia(int p) {
        if(p >= 0 && p <= 10) {
            System.out.println("Passant potencia " + p);

            for (int i = 0; i <motors.length; i++) {
                motors[i].setPotencia(p);
            }
        } else {
            System.out.printf("Error de potencia (%d) no en [0-10]",p);
        }
    }

    public void arranca() {
        for (int i = 0; i < motors.length; i++) {
            motors[i].start();
        }
    }

    public static void main(String[] args) {
        Coet c = new Coet();
        int potencia;
        Scanner sc = new Scanner(System.in);

        potencia = sc.nextInt();
        c.passaPotencia(potencia);
        c.arranca();

        do{
            potencia = sc.nextInt();
            c.passaPotencia(potencia);
        } while (potencia != 0);

        sc.close();
    }
}
