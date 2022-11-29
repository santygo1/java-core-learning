package com.ds.DataStructures;

import java.util.Arrays;

/**
 * @author Danil on 26.11.2022
 * @project JavaCoreLearning
 */
public class Fibonacci {

    public static void main(String[] args) {
        long timePointer;

        timePointer = System.currentTimeMillis(); //set time pointer for naive algorithm
        //do the method
        System.out.println(fibNaive(30));

        System.out.println("naive method time: " + (System.currentTimeMillis() - timePointer));

        timePointer = System.currentTimeMillis(); //set time pointer for effective algorithm
        //do the method
        System.out.println(fibEffective(100));

        System.out.println("effective method time: " + (System.currentTimeMillis()-timePointer));


        // Мемоизация неэффективного алгоритма
        int n = 100;
        long[] mem = new long[n+1];
        Arrays.fill(mem, -1); // Заполняет весь массив значениями -1

        timePointer = System.currentTimeMillis(); // set time pointer for memoized naive algorithm
        //do the method
        System.out.println(memoizationFibNaive(n,mem));

        System.out.println("memoized naive method time: " + (System.currentTimeMillis() - timePointer));

    }

    // *Каждая операция имеет смысл
    // O(n)
    private static long fibEffective(int n){
        long[] arr =  new long[n+1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    // Очень неэффективный алгоритм, по подсечтом чтобы вычислить 100 число фибоначи пришлось
    // бы ждать околок 50000 лет
    // *Делает много повторяющихся вычислений
    // O(2^n)
    private static long fibNaive(int n) throws IllegalArgumentException{
        if (n < 0) throw new IllegalArgumentException("n must be bigger then 0");
        if (n <= 1)
            return n; // 0 or 1

        return fibNaive(n-1) + fibNaive(n-2);
    }

    // Мемоизация неэффективного алгоритма
    private static long memoizationFibNaive(int n, long[] mem){
        if (mem[n] != -1)
            return mem[n];

        if (n <= 1)
            return n; // 0 or 1

        long result = memoizationFibNaive(n-1, mem) + memoizationFibNaive(n-2, mem);
        mem[n] = result;

        return mem[n];
    }

}
