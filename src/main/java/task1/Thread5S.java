package task1;

public class Thread5S implements Runnable {
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()){
            synchronized (this){
                if (!pause5S()) break;
                System.out.println("5 sec passed");
            }
        }
    }
    private boolean pause5S(){
        for (int i = 0; i < 5; i++) {
            try {
                wait(1000);
            }catch (InterruptedException e){
                return false;
            }
            notifyAll();
        }
        return true;
    }
}
