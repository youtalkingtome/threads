public class TaskManager implements Runnable {

    private volatile boolean shutdown=false;

    public void shutdown()
    {
        shutdown=true;
    }

    @Override
    public void run() {
        while(!shutdown)
        {
            //processing
        }
    }
}
