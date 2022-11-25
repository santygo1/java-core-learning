package com.ds.InitialSequence;

/**
 * @author Danil on 25.11.2022
 * @project JavaCoreLearning
 */
public class Person {
    static int a = 10;
    static int b = 5;
    static int hardCalculation;

    static {
        hardCalculation = a + b;
    }

    private Person() {
        System.out.println("Конструктор Person()");
    }

    public Person(String somethingText){
        this();
        System.out.println("Конструктор Person(String)" + somethingText);
    }

    public Person(String somethingText, int somethingNumber){
        this(somethingText);
        System.out.println("Конструктор Person(int, String)" + somethingText + " " + somethingNumber);
    }


}
