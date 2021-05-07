package task1;

public class Main {
    public static void main(String[] args) {
        Thread thread1S = new Thread(new Thread1S());
        Thread thread5S = new Thread(new Thread5S());
        thread1S.start();
        thread5S.start();
        try {
            Thread.sleep(30000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread1S.interrupt();
        thread5S.interrupt();
    }
}
