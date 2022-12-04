package com.ds.lambdas;

/**
 * @author Danil on 04.12.2022
 * @project JavaCoreLearning
 */
public class SimpleImplementation {

    public static void main(String[] args) {
        Operation sum = (x,y) -> x+y;
        Operation mul = (x,y) -> x*y;

        System.out.println(sum.calculate(10,15));
        System.out.println(mul.calculate(10,10));
    }
}

@FunctionalInterface
interface Operation{
    int calculate(int x, int y);
}
