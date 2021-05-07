package task2;

import java.util.Arrays;

public class TaskTwo {
    public static String stringReplacement (int n){
        int[] integers = new int[n];
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            integers[i] = i+1;
        }

        Thread frizzThread = new Thread(() ->{
            fizz(integers,strings);
        });
        frizzThread.start();
        Thread buzzTread = new Thread(() ->{
            buzz(integers,strings);
        });
        buzzTread.start();
        Thread fizzBuzzTread = new Thread(()->{
            fizzBuzz(integers,strings);
        });
        fizzBuzzTread.start();
        Thread numberThread = new Thread(()->{
            number(integers,strings);
        });
        numberThread.start();
        while (!allTreadTerminated(frizzThread,buzzTread,fizzBuzzTread,numberThread)){
            sleepOneSec();
        }
        return String.join(", ", Arrays.asList(strings));
    }
    private static void sleepOneSec(){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    private static boolean allTreadTerminated(Thread... threads){
        boolean terminated = true;
        for (Thread thread: threads){
            terminated = terminated && thread.getState() == Thread.State.TERMINATED;
        }
        return terminated;
    }
    private static void fizz(int[] integers, String[] strings){
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 5 != 0 && integers[i] % 3 == 0){
                strings[i] = "fizz";
            }
        }
    }
    private static void buzz(int[] integers, String[] strings){
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 5 == 0 && integers[i] % 3 != 0){
                strings[i] = "buzz";
            }
        }
    }
    private static void fizzBuzz(int[] integers, String[] strings){
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 5 == 0 && integers[i] % 3 == 0){
                strings[i] = "fizzbuzz";
            }
        }
    }
    private static void number(int[] integers, String[] strings){
        for (int i = 0; i < integers.length; i++) {
            if (strings[i] == null){
                strings[i] = String.valueOf(integers[i]);
            }
        }
    }
}
