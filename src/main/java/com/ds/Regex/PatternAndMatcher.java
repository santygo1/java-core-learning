package com.ds.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Danil on 02.12.2022
 * @project JavaCoreLearning
 */
public class PatternAndMatcher {
    /*
        Эти два класса расширяют возможности использования regex
     */

    public static void main(String[] args) {
        String text = "Hsadasdasdasdasdasd asdasdasdasdasd sada sdas"
                + "sadasdasdasdasd sda12124 myemail@gmail.com "
                + "sadasdasdasdasdasdasdasdasd asdasdasdasdasd"
                + "sadasdasd email2@ya.ru asdasdasdasdasdasdasd";

        Pattern email = Pattern.compile("(\\w+)@(gmail|ya)\\.(com|ru)");
        // В скобках обьединяем в группы у каждой группы есть свой id
        // у группы (\\w) айди - 1

        // Нумерация идет слева направо начиная с 1
        // 1  2  3
        // () () ()

        // для вложенных:
        //        1
        //     2     3
        // (  ()     ()  )

        //  1
        //  2      3
        // (())   ()

        Matcher matcher = email.matcher(text);
        while (matcher.find()){
            System.out.print(matcher.group()); //Вывод всех совпадений
            // group - без аргументов, выводит совпадение
            // аргумент число -
            System.out.print(" ");
            System.out.println(matcher.group(2));
        }
    }
}
