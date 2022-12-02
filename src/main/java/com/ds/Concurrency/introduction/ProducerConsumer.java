package com.ds.Concurrency.introduction;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
/**
 * @author Danil on 30.11.2022
 * @project JavaCoreLearning
 */
public class ProducerConsumer {
    private final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    private final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
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

    private void consume() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            System.out.println("Consumer take - " + queue.take());
        }
    }

    void produce() throws InterruptedException {
        while (true){
            System.out.println("Producer puts");
            queue.put(random.nextInt(100));
            System.out.println("Size of queue: " + queue.size());
        }
    }

}