import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    // A semaphore with 3 permits
    private final Semaphore semaphore = new Semaphore(3);

    public void accessResource() {
        try {
            // Acquire a permit before accessing the resource
            semaphore.acquire();
            System.out.println("Thread " + Thread.currentThread().getId() + " is accessing the resource.");
            // Simulate resource access
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Release the permit after accessing the resource
            semaphore.release();
            System.out.println("Thread " + Thread.currentThread().getId() + " has released the resource.");
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();
        // Create and start multiple threads
        for (int i = 0; i < 10; i++) {
            new Thread(example::accessResource).start();
        }
    }
}
