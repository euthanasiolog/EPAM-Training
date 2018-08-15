package com.epam.training.task3.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.epam.training.task3.entity.Tunnel;
import com.epam.training.task3.pool.WaitingPool;
import org.apache.log4j.Logger;

public class DispatcherThread extends Thread {
    private static final int MAX_IN_TUNNEL_TRAIN_COUNT = 3;
    private static final int MAX_ROW_TRAIN_COUNT = 4;
    private final Lock lock = new ReentrantLock();
    private WaitingPool pool;
    private Tunnel tunnelTrue;
    private Tunnel tunnelFalse;
    private int trueQueueCount;
    private int falseQueueCount;

    public DispatcherThread(WaitingPool pool, Tunnel tunnelTrue, Tunnel tunnelFalse) {
        this.pool = pool;
        this.tunnelTrue = tunnelTrue;
        this.tunnelFalse = tunnelFalse;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (trueQueueCount < MAX_ROW_TRAIN_COUNT){
                checkAndSendPriorityTrain(tunnelTrue);
            } else {
                sendTrain(tunnelFalse);
            }

            if (falseQueueCount < MAX_ROW_TRAIN_COUNT){
                checkAndSendPriorityTrain(tunnelFalse);
            } else {
                sendTrain(tunnelTrue);
            }

            if (tunnelTrue.getTrainCount() == 0 && tunnelFalse.getTrainCount() == 0){
                sendTrain(tunnelTrue);
            }

        }
    }

    private void checkAndSendPriorityTrain(Tunnel tunnel) {
        if (!tunnel.isBusyFlag() && tunnel.getTrainCount() > 0
                && tunnel.getTrainCount() < MAX_IN_TUNNEL_TRAIN_COUNT) {
            sendTrain(tunnel);
        }
    }

    private void sendTrain(Tunnel tunnel) {
        try {
            lock.lock();
            for (int i = 0; i < pool.getSize(); i++) {
                if (pool.getTrain(i).getDirection() == tunnel.getDirection()) {
                    new TrainThread(pool.getTrain(i), tunnel).start();
                    System.out.println("Train " + pool.getTrain(i).getDirection() + " sended.");
                    if (pool.getTrain(i).getDirection()){
                        trueQueueCount++;
                        falseQueueCount = 0;
                    } else {
                        falseQueueCount++;
                        trueQueueCount = 0;
                    }
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

