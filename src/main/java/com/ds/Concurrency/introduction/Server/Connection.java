package com.ds.Concurrency.introduction.Server;

import java.util.concurrent.Semaphore;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class Connection {
    private static final Connection connection = new Connection();

    private Semaphore semaphore = new Semaphore(10);

    private int connectionsCount = 0;
    private Connection(){

    }

    public static Connection getInstance() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }
    }
    private void doWork() throws InterruptedException {
        synchronized (this){
            connectionsCount++;
            System.out.println(connectionsCount);
        }

        Thread.sleep(1000);

        synchronized (this){
            connectionsCount--;
        }
    }
}
