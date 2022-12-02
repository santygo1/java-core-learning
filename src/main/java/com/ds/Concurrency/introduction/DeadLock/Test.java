package com.ds.Concurrency.introduction.DeadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
    }

    static class Runner {

        private final Account acc1 = new Account();
        private final Account acc2 = new Account();

        private Lock lock1 = new ReentrantLock();
        private Lock lock2 = new ReentrantLock();

        private void takeLocks(Lock lock1, Lock lock2) {
            boolean firstLockTaken = false;
            boolean secondLockTaken = false;

            while (true){
                try {
                    firstLockTaken = lock1.tryLock();
                    secondLockTaken = lock2.tryLock();
                } finally {
                    if (firstLockTaken && secondLockTaken) return;

                    if (firstLockTaken) {
                        lock1.unlock();
                    }

                    if (secondLockTaken) {
                        lock2.unlock();
                    }
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        public void firstThread() {
            for (int i = 0; i < 10000; i++) {
                //Выполнится только тогда когда поток завладеет всеми данными
//                synchronized (acc1){
//                    synchronized (acc2){
//                        Account.transfer(acc1, acc2, new Random().nextInt(100));
//                    }
//                }
                takeLocks(lock1, lock2);
                try {
                    Account.transfer(acc1, acc2, new Random().nextInt(100));
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        }

        public void secondThread() {
            for (int i = 0; i < 10000; i++) {
                //Выполнится только тогда когда поток завладеет всеми данными
//                synchronized (acc1) {
//                    synchronized (acc2) {
//                        Account.transfer(acc2, acc1, new Random().nextInt(100));
//                    }
//                }
                takeLocks(lock2, lock1);
                try {
                    Account.transfer(acc2, acc1, new Random().nextInt(100));
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        }

        public void finished() {
            System.out.println("First account balance: " + acc1.getBalance());
            System.out.println("Second account balance: " + acc2.getBalance());
            System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
        }
    }

    static class Account {
        private int balance = 10000;

        public void deposit(int amount) {
            balance += amount;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }

        public int getBalance() {
            return balance;
        }

        public static void transfer(Account acc1, Account acc2, int amount) {
            acc1.withdraw(amount);
            acc2.deposit(amount);
        }
    }
}
