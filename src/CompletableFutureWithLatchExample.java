import java.util.concurrent.*;

public class CompletableFutureWithLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int numberOfTasks = 5;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try {
                    // Simulate task execution time
                    Thread.sleep((long) (Math.random() * 2000));
                    System.out.println("Task executed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // Count down the latch after the task is completed
                    latch.countDown();
                }
            }, executor);
        }

        // Wait for all tasks to complete
        System.out.println("Main thread is waiting for tasks to complete");
        latch.await();
        System.out.println("All tasks completed. Proceeding with the main thread");

        // Shut down the executor to exit the program cleanly
        executor.shutdown();
    }
}
