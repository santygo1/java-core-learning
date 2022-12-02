package com.ds.Concurrency.introduction.Server;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            executorService.submit(() -> {
                try {
                    Connection.getInstance().work();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown(); // Закончили задавать задания
        executorService.awaitTermination(1, TimeUnit.DAYS);

    }
}
