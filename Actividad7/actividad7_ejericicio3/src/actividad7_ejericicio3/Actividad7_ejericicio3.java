package actividad7_ejericicio3;

class SumadorRunnable implements Runnable {
    @Override
    public void run() {
        int suma = 0;
        try {
            for (int i = 1; i <= 10; i++) {
                suma += i;
                System.out.println("Sumando: " + i);
                Thread.sleep(500); 
            }
            System.out.println("Total: " + suma);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        SumadorRunnable tarea = new SumadorRunnable();
        
        
        Thread hilo = new Thread(tarea);
        hilo.start();

        
        System.out.println("Hilo principal sigue ejecutando");
    }
}
