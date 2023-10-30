package t5;

public class ThreadDemo extends Thread {
    public void run() {
        System.out.println("Hilo creado extendiendo la clase Thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }
}