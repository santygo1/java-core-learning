package com.ds.interfaceimpl.simple;

/**
 * @author Danil on 05.12.2022
 * @project JavaCoreLearning
 */
public class MinusPrinter implements Printer{

    @Override
    public <T> void print(T s) {
        System.out.println("---" + s.toString() + "---");
    }
}
