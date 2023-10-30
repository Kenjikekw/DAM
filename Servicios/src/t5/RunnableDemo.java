package t5;

public class RunnableDemo implements Runnable {
    public void run() {
        System.out.println("Hilo creado implementando la interfaz Runnable: " + Thread.currentThread().getName());
    }

    public static class RunnableDemo2 implements Runnable {
        public void run() {
            System.out.println("Hilo 2 creado implementando la interfaz Runnable: " + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        Thread thread2 = new Thread(new RunnableDemo2());

        thread.start();
        thread2.start();
    }
}