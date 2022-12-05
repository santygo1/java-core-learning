package com.ds.interfaceimpl.simple;

/**
 * @author Danil on 05.12.2022
 * @project JavaCoreLearning
 */
public class DataPrinter {
    private Printer printer = new MinusPrinter();
    public<T> void print(T word){
        printer.print(word);
    }

}
