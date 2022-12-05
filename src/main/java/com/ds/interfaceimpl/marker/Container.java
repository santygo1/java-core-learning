package com.ds.interfaceimpl.marker;

/**
 * @author Danil on 05.12.2022
 * @project JavaCoreLearning
 */
public class Container<T extends Summable> {
    public void sum(T t){
        t.sum();
    }

}
