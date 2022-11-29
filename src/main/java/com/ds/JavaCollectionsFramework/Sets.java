package com.ds.JavaCollectionsFramework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Danil on 29.11.2022
 * @project JavaCoreLearning
 */
public class Sets {

    public static void main(String[] args) {
        /*
            Множество уникальных значений
         */
        Set<String> set;

        set = new HashSet<>();
        //set = new LinkedHashSet<>();
        //set = new TreeSet<>();

        set.add("sds");
        set.add("sda");
        set.add("222");
        set.add("2312");
        set.add("sds");

        for (String string : set) System.out.println(string);

        Set<Integer> firstNumberSet = new HashSet<>();
        initNumberSetRandomly(firstNumberSet, 20, 0,100);

        Set<Integer> secondNumberSet = new HashSet<>();
        initNumberSetRandomly(secondNumberSet,10 , 0, 100);

        // Обьединение
        Set<Integer> union = new HashSet<>(firstNumberSet);
        union.addAll(secondNumberSet);

        // Пересечение двух множеств
        Set<Integer> intersection = new HashSet<>(firstNumberSet);
        intersection.retainAll(secondNumberSet); // Оставляет все элементы которые из все что в переданном есть в сете 1

        // Разность
        Set<Integer> difference = new HashSet<>(firstNumberSet);
        difference.removeAll(secondNumberSet);

        // Симметричная разность
        union.removeAll(intersection);
    }

    private static void initNumberSetRandomly(Set<Integer> numbersSet, int countOfNumbers,
                                                      int numbersFrom, int numbersTo){
        int currentIteration = 1;
        while (currentIteration <= countOfNumbers){
            numbersSet.add((int)(Math.random()*numbersTo) + numbersFrom);
            currentIteration++;
        }
    }
}
