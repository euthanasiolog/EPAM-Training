package com.epam.training.task3.controller;

//import statements
import com.epam.training.task3.entity.Tunnel;
import com.epam.training.task3.pool.WaitingPool;
import com.epam.training.task3.thread.CreatorThread;
import com.epam.training.task3.thread.DispatcherThread;
import com.epam.training.task3.thread.WaitingPoolMonitorThread;

public class Starter {
    public static void main(String[] args) {
        Tunnel tunnelTrue = new Tunnel(true);
        Tunnel tunnelFalse = new Tunnel(false);

        /*ArrayList<Future<Train>> arrayList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);*/

        WaitingPool waitingPool = WaitingPool.getInstance();

        CreatorThread creatorThread = new CreatorThread(waitingPool);
        creatorThread.start();

        WaitingPoolMonitorThread poolMonitor = new WaitingPoolMonitorThread(waitingPool);
        poolMonitor.setDaemon(true);
        poolMonitor.start();

        DispatcherThread dispatcher = new DispatcherThread(waitingPool, tunnelTrue, tunnelFalse);
        dispatcher.setDaemon(true);
        dispatcher.start();
    }
}

