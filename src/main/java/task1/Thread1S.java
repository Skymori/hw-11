package task1;

import java.util.Date;

public class Thread1S implements Runnable{

    @Override
    public void run() {
        Date start = new Date();
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()){
            synchronized (this){
                if (!pause1S()) break;
            }
            System.out.println((new Date().getTime() - start.getTime())/1000);
        }
    }
    private boolean pause1S(){
        try {
            wait(1000);
        }catch (InterruptedException e){
            return false;
        }
        notifyAll();
        return true;
    }
}
