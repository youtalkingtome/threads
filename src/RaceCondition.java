import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class RaceCondition {
    private int counter = 0;
    private final Object lock = new Object();

    public static void main(String[] args) {
        RaceCondition example = new RaceCondition();
        example.proceed();
    }

    private void proceed() {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Using 2 threads

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        }, executor);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        }, executor);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        combinedFuture.thenRun(() -> System.out.println("Final counter value: " + counter)).join();

        executor.shutdown();
    }

    private void incrementCounter() {
        //synchronized (lock) {
            counter = counter + 1;
        //}
    }
}
