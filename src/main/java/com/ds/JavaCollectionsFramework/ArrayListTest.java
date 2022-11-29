package com.ds.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil on 26.11.2022
 * @project JavaCoreLearning
 */
public class ArrayListTest {

    // Плюсы: доступ к элементу - O(const)
    // Минусы: Удаление и добавление -> пересоздание массива с большим размером в который переносятся
    //         все элементы из старого, что при большом количестве элементов занимает большое количество времени
    // Вывод: Если у нам нужен список который будет редко изменяться и нам важно быстро получать элементы
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            integers.add(i+1);

        long timePointer = System.currentTimeMillis();
        integers.remove(integers.size()/2);
        // По временени очень затратно, т.к происходит смещение всех элементов
        // Стоящих после удаленного
        // После чего длина массива сокращается
        System.out.println(System.currentTimeMillis() - timePointer);
    }
}
