package com.epam.training.task3.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.epam.training.task3.pool.WaitingPool;

public class WaitingPoolMonitorThread extends Thread {
    //private static Logger log = Logger.getLogger(WaitingPoolMonitorThread.class);
    private final Lock lock = new ReentrantLock();
    private WaitingPool pool;

    private static final int SLEEP = 3;

    public WaitingPoolMonitorThread(WaitingPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock.lock();
                System.out.println("Pool size = " + pool.getSize());
            } finally {
                lock.unlock();
            }

        }
    }
}

