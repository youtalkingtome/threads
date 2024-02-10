import java.util.concurrent.TimeUnit;

public class StopThread {
    private static  boolean stopRequested;

    public static void main(String[] args) throws InterruptedException{
        long startTime = System.currentTimeMillis();
        Thread backGroundThread= new Thread(()->{
            int i=0;
            while(!stopRequested)
                i++;
        });
        backGroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested=true;
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print(estimatedTime);

    }
}
