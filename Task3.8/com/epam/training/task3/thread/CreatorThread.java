package com.epam.training.task3.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.epam.training.task3.entity.Train;
import com.epam.training.task3.pool.WaitingPool;

public class CreatorThread extends Thread {
    //fields
    private final Lock lock = new ReentrantLock();
    private WaitingPool pool;

    //constant values
    private static final int NUMBER_OF_TRAINS = 10;
    private static final int SLEEP = 10;

    public CreatorThread(WaitingPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < NUMBER_OF_TRAINS; i++){
            try{
                TimeUnit.SECONDS.sleep(random.nextInt(SLEEP));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Train train = new Train(random.nextBoolean());

            try{
                lock.lock();
                pool.add(train);
            } finally {
                lock.unlock();
            }
        }
    }

    /*@Override
    public Train call() throws Exception{
        return null;
    }*/
}

