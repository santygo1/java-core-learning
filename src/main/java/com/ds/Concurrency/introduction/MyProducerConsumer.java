package com.ds.Concurrency.introduction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Danil on 30.11.2022
 * @project JavaCoreLearning
 */
public class MyProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        NewProducerConsumer wn = new NewProducerConsumer();

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        consumer.start();
        producer.start();

        consumer.join();
        producer.join();
    }

}

class WaitAndNotify{
    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized(this) {
            System.out.println("Waiting for write something");
            scanner.nextLine();
            notify();
//            notifyAll(); пробуждает все потоки привязанные к обьекту с текущим монитором
        }
    }

    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer starts");
            wait(); // отдает intrinsic lock
            System.out.println("Producer resumed");

        }
    }
}

class NewProducerConsumer {

    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while (true){
            synchronized (lock){
                if (queue.size() == LIMIT) lock.wait();
                queue.offer(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true){
            synchronized (lock){
                if (queue.size() == 0) lock.wait();
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size is " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}
