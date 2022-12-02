package com.ds.Concurrency.introduction;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class ReentrantLockImplementation {

    //ReentrantLock - Класс помогающий синхронизировать потоки

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();
    }

    static class Task{
        private int counter;
        private Lock lock = new ReentrantLock();

        private void inc(){
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        }

        public void firstThread(){
            lock.lock();
            inc();
            lock.unlock();
        }

        public void secondThread(){
            lock.lock();
            inc();
            lock.unlock();
        }

        public void showCounter(){
            System.out.println(counter);
        }
    }
}
