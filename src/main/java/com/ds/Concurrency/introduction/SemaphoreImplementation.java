package com.ds.Concurrency.introduction;

import java.util.concurrent.Semaphore;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class SemaphoreImplementation {
    /*
        Семафор используется когда есть много потоков которые используют один ресурс
        и мы хотим ограничить доступ к этому ресурсу
     */

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);

        semaphore.release();//Возвращает разрешение из текущего потока

        semaphore.acquire();//Забирает одно разрешение текущего потока

        semaphore.availablePermits(); // Возвращает количество разрешений
    }


}
