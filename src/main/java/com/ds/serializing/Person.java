package com.ds.serializing;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


/**
 * @author Danil on 25.11.2022
 * @project JavaCoreLearning
 */
@Getter
@Setter
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 2239141951208688864L;
    private int age;
    private String name;
    private Wallet wallet;

    Person(String name, int age) {
        this.age = age;
        this.name = name;
        this.wallet = new Wallet(0);
    }

    @Override
    public String toString() {
        return "Person:" +
                '\n' + '\t' + "Name: " + name +
                '\n' + '\t' + "Age: " + age +
                '\n' + '\t' + wallet;
    }
}
