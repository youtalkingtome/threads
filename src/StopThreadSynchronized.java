import java.util.concurrent.TimeUnit;

public class StopThreadSynchronized {

    private static  boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }
    public static void main(String[] args) throws InterruptedException{

        Thread backGroundThread= new Thread(()->{
            int i=0;
            while(!stopRequested())
                i++;
        });
        backGroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();

    }
}
