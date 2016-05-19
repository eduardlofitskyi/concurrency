package core.incdecrace;

/**
 * Created by eduard on 1/21/16.
 */
public class IncDecRace {

    public static void main(String[] args) {

        Runnable increment = () -> {
            int a=0;
            long start = System.nanoTime();
            while (true) {
                if (a == 100) break;
                a++;
            }
            System.err.println("inc: "+(System.nanoTime()-start));
        };

        Runnable decrement = () -> {
            int a=0;
            long start = System.nanoTime();
            while (true) {
                if (a == -100) break;
                a--;
            }
            System.err.println("dec: "+(System.nanoTime()-start));
        };

        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(decrement);
        t1.start();
        t2.start();
    }
}
