package com.ds.Regex;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class Main {

    public static void main(String[] args) {

        /*
               \\d - целое число
               \\w - одна буква

               ^ - начало строки
               $ - конец строки

               + - один или более
               * - ноль или более
               ? - ноль или 1 символов до
               (x|y|z) - одно из множества строк

               \\ - переводят специальный символ в обычный символ, и наоборот

               [] - описывает множества Пример [a-zA-Z] - все английские символы
                                                [abc] - тоже самое что и (a|b|c)
                                                [0-9] - 0 ... 9
               ^ - отрицание. Пример [^abc] - все кроме abc
               . - любой символ

                {0,9} - количество символов от 0 до 9.
                {2, } - от двух символов.
                {2} - ровно два символа.
         */
        String firstURL = "https://www.hello-world.com";
        String secondURL = "https://www.drom.ru";
        String pattern = "https://www\\..+\\.(com|ru)";

        System.out.println(firstURL.matches(pattern));
        System.out.println(secondURL.matches(pattern));


        /*
            replaceAll - заменяет с использованием regex
            replace - заменяет строки
            replaceFirst - заменяет с помощью regex первое вхождение

         */
    }
}
