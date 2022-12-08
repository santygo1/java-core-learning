package com.ds.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Danil on 08.12.2022
 * @project JavaCoreLearning
 */
public class SimpleConsoleClassManager {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {

        Scanner scanner = new Scanner(System.in);

        //Название_класса_1 Название_класса_2 Название_метода
        Class classObject1 = Class.forName(scanner.next());
        Class classObject2 = Class.forName( scanner.next());
        String methodName = scanner.next();

        Method method = classObject1.getMethod(methodName, classObject2);
        Object o1 = classObject1.newInstance();
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value..");

        method.invoke(o1, o2);// вызвает текущий метод на обьекте o1 с параметром o2

        System.out.println(o1);
    }
}
