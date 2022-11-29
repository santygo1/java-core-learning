package com.ds.JavaCollectionsFramework;

import java.util.*;

/**
 * @author Danil on 29.11.2022
 * @project JavaCoreLearning
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Jack", 26));
        persons.add(new Person("Daniel", 74));
        persons.add(new Person("Vasya",44));
    }
}

class AgePersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class NameLengthPersonComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length() > o2.getName().length()) return 1;
        else if (o1.getName().length() < o2.getName().length()) return -1;
        else return 0;
    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
        Контракт equal- hashcode заключается в следующем:
        Сначала сравниваются hashcode:
        если они "!=" -> обьекты разные
        иначе -> сравниваем по equals(который дает однозначно понять равны они или нет)
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // проверяем что ссылки ссылаются на один и тот же обьект
        if (o == null || getClass() != o.getClass()) return false; // если передаваемая ссылка ноль или этот класс не равен передаваемому классу

        // Иначе обьекты одного класса и мы можем безопасно его закастить
        Person person = (Person) o;

        // Делаем проверку по поляем и возвращаем булево значение равенства
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
