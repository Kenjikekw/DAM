package t5;

public class ThreadSyncDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                resource.setMessage("Mensaje " + i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                System.out.println("Consumidor 1 Recibido: " + resource.getMessage());
            }
        });
        
        Thread consumer2 = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                System.out.println("Consumidor 2 Recibido: " + resource.getMessage());
            }
        });
        
        Thread consumer3 = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                System.out.println("Consumidor 3 Recibido: " + resource.getMessage());
            }
        });

        producer.start();
        consumer.start();
        consumer2.start();
        consumer3.start();
    }
}
