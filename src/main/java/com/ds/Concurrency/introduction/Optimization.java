package com.ds.Concurrency.introduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Danil on 30.11.2022
 * @project JavaCoreLearning
 */
public class Optimization {

    public static void main(String[] args) {
        new Worker().main();
    }
}

class Worker{
    private final List<Integer> integers = new LinkedList<>();
    private final List<Integer> anotherIntegers = new LinkedList<>();

    private Random random = new Random();

    public void addToIntegers(){
        synchronized (integers){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            integers.add(random.nextInt(100));
        }
    }

    public void addToAnotherIntegers(){
        synchronized (anotherIntegers){
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            anotherIntegers.add(random.nextInt(100));
        }
    }

    public void work(){
        for (int i = 0; i < 500; i++) {
            addToIntegers();
            addToAnotherIntegers();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long after = System.currentTimeMillis();
        System.out.println("Размер integers" + integers.size());
        System.out.println("Размер anotherIntegers" + anotherIntegers.size());
        System.out.println("Время выполнения программы" + (after - before) + " мс.");
    }
}
