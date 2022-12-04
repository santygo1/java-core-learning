package com.ds.lambdas;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Danil on 04.12.2022
 * @project JavaCoreLearning
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = initListByOrder(1, 20);
        int[] array = initArrayByOrder(20, 40);

        System.out.println("List of integers: " + list);
        System.out.println("Array of integers: " + Arrays.toString(array));

        //mapping
        Random random = new Random();
        list = list.stream()
                .map(a -> a * random.nextInt(100))// change list value by multiplying on random coefficient
                .collect(Collectors.toList());

        array = Arrays.stream(array)
                .map(a -> a * random.nextInt(100)) // change array value by multiplying on random coefficient
                .toArray();

        System.out.println("Map list: " + list);
        System.out.println("Map array: " + Arrays.toString(array));

        //filter
        list = list.stream()
                .filter(a -> a % 2 != 0)
                .collect(Collectors.toList());
        array = Arrays.stream(array)
                .filter(a -> a % 2 == 0).toArray();

        System.out.println("Filter list(even): " + list);
        System.out.println("Filter array(odd): " + Arrays.toString(array));

        //foreach
        Arrays.stream(array).forEach(System.out::println);
        list.stream().forEach(System.out::println);


        //reduce(уменьшение) -> сжимает в один элемент
        int sumListElements = list.stream().reduce(0, (acc, current) -> acc + current); // 0 - начальное значение аккамулятора
        int sumArrayElements =
                Arrays.stream(array)
                        .reduce((accumulator, currentElement) -> accumulator + currentElement)
                        .getAsInt();
        // IDE ругается потому что нет проверки isPresent
        // А такое может случаться только когда может вернуться ничего

        System.out.println("Sum all elements from list:" + sumListElements);
        System.out.println("Sum all elements from array: " + sumArrayElements);

        // Пример reduce с факториалом
        System.out.println("Factorial 5: " + factorial(5));

        // Обычно стараются его не использовать так как он запутанный, но если что то простое то он отлично подходит
        // для этих целей
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

    public static int factorial(int number) {
        int[] numbers = initArrayByOrder(0, number + 1);
        return Arrays.stream(numbers)
                .reduce(1,(factor, current) -> {
                    if (current != 0) factor *= current;
                    return factor;
                });
    }
}
