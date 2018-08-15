package com.epam.training.task3.thread;

import com.epam.training.task3.entity.Train;
import com.epam.training.task3.entity.Tunnel;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrainThread extends Thread {
    private final Lock lock = new ReentrantLock();
    private Train train;
    private Tunnel tunnel;

    public TrainThread(Train train, Tunnel tunnel) {
        this.train = train;
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        tunnel.setBusyFlag(true);
        try {
            lock.lock();
            tunnel.addTrain(train);
        } finally {
            lock.unlock();
        }

        tunnel.incrementTrainCount();
        train.busyGo();
        tunnel.setBusyFlag(false);
        train.restGo();

        try {
            lock.lock();
            tunnel.removeTrain();
        } finally {
            lock.unlock();
        }
        tunnel.decrementTrainCount();
        System.out.println("Train " + train.getDirection() + " passed.");
    }
}

