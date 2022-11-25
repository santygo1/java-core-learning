package com.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil on 25.11.2022
 * @project JavaCoreLearning
 */
public class WildCard {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();

        method1(animals);
//        method1(dogs); doesn't work

        method2(animals);
        method2(dogs);

        method3(animals);
        method3(dogs);

        method3(animals);
//        method3(dogs); doesn't work because dog is child of animal not a parent
    }

    public static void method1(List<Animal> list){
        for (Animal animal: list){
            System.out.println(animal.getName());
        }
    }

    /**
     * @param list list of different objects
     */
    public static void method2(List<?> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    /*
        for list of animal childs 
     */
    public static void method3(List<? extends Animal> list){
        for (Animal animal : list) {
            System.out.println(animal.getName());
        }
    }

    /*
        for something that upper then Animal in hierarchy
     */
    public static void method4(List<? super Animal> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

class Animal{
    private String name;

    Animal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal{
    Dog(String name){
        super(name);
    }
}
