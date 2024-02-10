import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Garage {
    private static final int TOTAL_SPOTS = 3;
    private final Semaphore semaphore = new Semaphore(TOTAL_SPOTS);
    private final Lock carsLock = new ReentrantLock();
    private final List<String> parkedCars = new ArrayList<>();

    public void enter(String carName) {
        try {
            semaphore.acquire();
            carsLock.lock();
            parkedCars.add(carName);
            System.out.println(carName + " parked");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            carsLock.unlock();
        }
    }

    public void exit(String carName) {
        carsLock.lock();
        try {
            parkedCars.remove(carName);
            System.out.println(carName + " leaving");
        } finally {
            carsLock.unlock();
            semaphore.release();
        }
    }

    public int countParkedCars() {
        return parkedCars.size();
    }

    public static void main(String[] args) {
        Garage garage = new Garage();

        // Simulating cars entering and exiting the garage
        for (int i = 1; i <= 5; i++) {
            String carName = "Car " + i;
            new Thread(() -> {
                garage.enter(carName);
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                garage.exit(carName);
            }).start();
        }
    }
}
