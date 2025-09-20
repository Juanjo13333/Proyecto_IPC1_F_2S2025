package ejercicio2;

class MensajeThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Este es un mensaje desde un hilo (" + i + ")");
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class main {
    public static void main(String[] args) {
      
        MensajeThread hilo = new MensajeThread();
        hilo.start();

   
        System.out.println("Mensaje desde el hilo principal (main).");
    }
}