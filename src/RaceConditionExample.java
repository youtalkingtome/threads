public class RaceConditionExample {
    private int counter = 0;

    public static void main(String[] args) {
        RaceConditionExample example = new RaceConditionExample();
        example.proceed();
    }

    private void proceed() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value: " + counter);
    }

    private  void incrementCounter() {
        counter = counter + 1;
    }
}
