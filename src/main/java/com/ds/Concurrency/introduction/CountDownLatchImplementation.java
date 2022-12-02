package com.ds.Concurrency.introduction;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Danil on 01.12.2022
 * @project JavaCoreLearning
 */
public class CountDownLatchImplementation {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processing(countDownLatch, i));
        }

        executorService.shutdown();

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}

class Processing implements Runnable{

    private final int id;
    private CountDownLatch countDownLatch;

    public Processing(CountDownLatch countDownLatch, int id){
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread with " + id + " proceeded.");
    }
}
