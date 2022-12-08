package com.ds.reflection;

/**
 * @author Danil on 08.12.2022
 * @project JavaCoreLearning
 */

@Author(name = "Danil", dateOfCreation = 2019)
public class Person {
    private int id;
    private String name;

    Person(){
        this.id = id;
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Person with id: " + id
                + " and name: " + name + " say hello");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
