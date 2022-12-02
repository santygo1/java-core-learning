package com.ds.Concurrency.introduction.CallableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class Test {

    /*
        Классы Callable и Future позволяют получать значения из потоков
     */
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException exception){
                    throw new RuntimeException();
                }
                System.out.println("Finishing");

                Random random = new Random();
                int randomValue = random.nextInt();
                if (randomValue < 5){
                    throw new Exception("Something bad happened");
                }
                return randomValue;
            }
        });
        executorService.shutdown();
        try {
            int result = future.get();//Get дожидается окончание выполнения потока
        } catch (ExecutionException e) { // Обработка выброшенной ошибки
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
    }

    public static int calculate() {
        return 5 + 4;
    }
}
