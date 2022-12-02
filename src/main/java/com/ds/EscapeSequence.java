package com.ds;

/**
 * @author Danil on 29.11.2022
 * @project JavaCoreLearning
 */
public class EscapeSequence {

    public static void main(String[] args) {
        String string = "Hello World";

        doTabulation(string);
        doNextLine(string);
        doBackspace(string);
        doNextPage(string);
        doReturn(string);


    }

    public static void doTabulation(String string){
        char tab = '\t'; // символ для табуляции
        System.out.println(tab + string);
    }

    public static void doNextLine(String string){
        char nextLine ='\n'; // символ для перехода на новую строку
        System.out.println(string + nextLine + string);
    }

    public static void doBackspace(String string){
        char backspace = '\b'; // символ возврата в тексте на один шаг назад или удаление одного символа в строке
        System.out.println(string + backspace);
    }

    public static void doReturn(String string){
        // Символ каретки позволяет нам вернуть курсор к началу строки вывода и отображать новую информацию
        // так, как будто ранее в этой строке ничего не было.
        char r = '\r';
        System.out.println(string + r );
    }

    public static void doNextPage(String string){
        char nextPage = '\f';
        System.out.println(string + nextPage);
    }
}
