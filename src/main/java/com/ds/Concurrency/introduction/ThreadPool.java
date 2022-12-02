package com.ds.Concurrency.introduction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil on 30.11.2022
 * @project JavaCoreLearning
 */
public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //Add new thread in queue
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Task(i));
        }
        executorService.shutdown(); // Finishing schedule

        executorService.awaitTermination(1, TimeUnit.DAYS); //Waiting for finishing all threads(1 day)
        // if it hasn't been finished in 1 day, it destroys
    }
}

class Task implements Runnable{

    private int id;

    Task(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("task " + id + " has been completed.");
    }
}