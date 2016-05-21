package java5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSample {

    private final Lock lock = new ReentrantLock();

    private int x;
    private int y;
    private AtomicInteger z;

    public LockSample(int x, int y, AtomicInteger z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public LockSample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = new AtomicInteger(z);
    }


    /**
     * Simple lock by synchronized block
     */
    public synchronized void increaseX(){
        x++;
    }

    /**
     * Obtain lock by special class Lock (ReentrantLock)
     */
    public synchronized void increaseY(){
        lock.lock();
        try {
            y++;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Try obtain lock for given time.
     * If the specified waiting time elapses then the value false is returned
     */
    public synchronized void decreaseY(){

        boolean acquired = false;

        try {
            acquired = lock.tryLock(1_000, TimeUnit.MILLISECONDS);
            if (acquired) y--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (acquired) lock.unlock();
        }
    }

    /**
     * Sample of using Atomic
     */
    public void increaseZ(){
        z.getAndIncrement();
    }
}
