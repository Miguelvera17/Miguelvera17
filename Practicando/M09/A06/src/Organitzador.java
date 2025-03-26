public class Organitzador {
    
    public static void main(String[] args){ 

        Assistent[] assistents = new Assistent[10];    
        Esdeveniment esdeveniment = new Esdeveniment(5);
        for (int i = 0; i < 10; i ++) {
            assistents[i] = new Assistent("Assistent-" + i, esdeveniment);
        }

        for (int i = 0; i < assistents.length; i++) {
            assistents[i].start();
        }
    }
}
