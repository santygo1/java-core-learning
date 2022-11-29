package com.ds.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Danil on 26.11.2022
 * @project JavaCoreLearning
 */
public class LinkedListTest {

    // Плюсы: добавление и удаление - O(n)
    // Минусы относильно ArrayList: Обращение к элементу -> O(n) (при обходе списка itli O(n^2), c итератором O(n)
    public static void main(String[] args) {
        //Допустим мы сначала такие работаем с ArrayList да
        List<Integer> integers = new ArrayList<>(List.of(1,2,3,4));

        // че то делаем
        // И бац захотели делать много удалений
        // Тогда перемещаем все в linked list

        integers = new LinkedList<>(integers);
        // и все удаляем и счастливы
    }
}
