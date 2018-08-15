package com.epam.training.task3.pool;

import com.epam.training.task3.entity.Train;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WaitingPool {
    private List<Train> trains = new ArrayList<>();
    private static WaitingPool instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private WaitingPool(){}

    public static WaitingPool getInstance(){
        lock.lock();
        try{
            if (instance == null){
                instance = new WaitingPool();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public void add(Train train){
        trains.add(train);
    }

    public int getSize(){
        return trains.size();
    }

    public Train getTrain(int index){
        return trains.get(index);
    }
}
