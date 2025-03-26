public class MainDemoFil {

    public static void main (String[] args) {
        Thread thr = Thread.currentThread();

        System.out.println("MainDemoFil:%n");
        System.out.printf("Prioritat -> %d,Nom -> %s%n", thr.getPriority(),thr.getName());
        System.out.printf("toString() -> %s%n",thr.toString());
    }
}