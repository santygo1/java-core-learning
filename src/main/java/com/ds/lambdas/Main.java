package com.ds.lambdas;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Danil on 04.12.2022
 * @project JavaCoreLearning
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = initListByOrder(1, 20);
        int[] array = initArrayByOrder(20, 40);

        System.out.println("Args: ");
        for (String arg : args) {
            System.out.println("arg: " + arg.replace("-", ""));
        }

        System.out.println("List of integers: " + list);
        System.out.println("Array of integers: " + Arrays.toString(array));

        Random random = new Random();
        list.stream().map(a -> a* random.nextInt(100)); // change list value by multiplying on random coefficient
        Arrays.stream(array).map(a -> a * random.nextInt(100)); // change array value by multiplying on random coefficient

        System.out.println(list);
        System.out.println(array);
    }

    /**
     * Creating new integers array with elements which pleasure the range
     *
     * @param from start integer
     * @param to   end integer
     * @return array with the elements which pleasure the range
     */
    private static int[] initArrayByOrder(int from, int to) {
        if (from > to) throw new RangeException();

        int[] array = new int[to - from];

        int range = from;

        for (int index = 0; index < array.length; index++)
            array[index] = range++;

        return array;
    }

    /**
     * Creating new integers list with elements which pleasure the range
     *
     * @param from start integer
     * @param to   end integer
     * @return list with the elements which pleasure the range
     */
    private static List<Integer> initListByOrder(int from, int to) {
        if (from > to) throw new RangeException();

        List<Integer> list = new LinkedList<>();

        int range = from;

        while (range <= to)
            list.add(range++);

        return list;
    }

    public static class RangeException extends IndexOutOfBoundsException {
        RangeException() {
            super("Range index are wrong");
        }
    }
}
