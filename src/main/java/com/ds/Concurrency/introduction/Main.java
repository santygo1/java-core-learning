package com.ds.Concurrency.introduction;

/**
 * @author Danil on 29.11.2022
 * @project JavaCoreLearning
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*
            Поток MyThread и Main никак не связаны. Main просто вызывает его и забывает.
         */
        MyThread myThread = new MyThread();
        myThread.start(); //Именно start а не run потому что за параллельность отвечает метод start

        Thread myAnotherThread = new Thread(new MyAnotherThread());
        myAnotherThread.start();

        System.out.println("Закончился");
    }
}

// такой вариант предпочтительнее так как он чище
class MyAnotherThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            double percent = (double)(i) / 10;
            System.out.println("Another thread in process " + percent + "%");
        }
    }
}
class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println("Hello world!");
        }
    }
}
