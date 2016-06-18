package core.incdecrace;

import org.slf4j.LoggerFactory;

/**
 * Show that decrement performs better thad increment
 */
public class IncDecRace {

    static final org.slf4j.Logger logger = LoggerFactory.getLogger(IncDecRace.class);

    public static void main(String[] args) {

        logger.trace("TRACE MESSAGE");
        logger.error("ERROR MESSAGE");

        Runnable increment = () -> {
            int a=0;
            long start = System.nanoTime();
            while (true) {
                if (a == Integer.MAX_VALUE) break;
                a++;
            }
            System.err.println("inc: "+(System.nanoTime()-start));
        };

        Runnable decrement = () -> {
            int a=0;
            long start = System.nanoTime();
            while (true) {
                if (a == -100);
                a--;
            }
        };

        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(decrement);
        t1.start();
        t2.start();
    }
}
