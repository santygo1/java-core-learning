package com.ds.Concurrency.introduction;

/**
 * @author Danil on 29.11.2022
 * @project JavaCoreLearning
 */
public class Test {

    private int counter;

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.doSomethingRight();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSomething() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter = counter + 1; // counter++ - неатомарная операция, на самом деле это 3 операции
                    // 1)считывание переменной counter
                    // 2) увеличение на единицу
                    // 3) запись нового значения
                    // из за потоки при работе с переменной counter путаются например
                    // 1: 100 -> 101 -> 101
                    // 2: 100
                    // 1: 101
                    // 2: 100 -> 101 -> 101 (хотя должно быть 102)
                }
            }
        });

        thread1.start();
        thread2.start();

        /*
            Дожидаемся остановки потоков
         */
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }

    public void doSomethingRight() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000 ; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }

    // synchronized - Только один поток в один момент времени получает доступ к телу метода
    private synchronized void increment() {
            counter++;
    }
}
