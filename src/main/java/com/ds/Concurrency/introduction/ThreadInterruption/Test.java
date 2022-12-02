package com.ds.Concurrency.introduction.ThreadInterruption;

import java.util.Random;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        Thread calculator = new Thread(new SinusCalculator());

        System.out.println("Thread is starting...");
        calculator.start();

        Thread.sleep(1000);
        calculator.interrupt();

//        calculator.interrupt(); Не прекращает работу потоку просто говорит JVM что нужно завершить поток
//        calculator.stop(); Многовенно прекращает работу потока(НЕ РЕКОМЕНДУЕТСЯ использовать.)

        calculator.join();
        System.out.println("Thread was finished!");
    }


    static class SinusCalculator implements Runnable{
        private Random random;

        SinusCalculator(){
            random = new Random();
        }
        public double calculate(double var){
            return Math.sin(var);
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000_000; i++) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("Thread was interrupted");
                    break;
                }
                System.out.println(calculate(random.nextInt()));
            }
        }
    }
}
