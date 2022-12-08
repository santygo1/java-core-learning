package com.ds.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Danil on 08.12.2022
 * @project JavaCoreLearning
 */
public class TestReflection {

    public static void main(String[] args) {
        // три способа получить обьект класса класс:
        // Первый
        Class personClass = Person.class;

        //Второй
        Person person = new Person();
        personClass = person.getClass();

        //Третий(выкинет экспешен если класс не будет найден по пути)
        try {
            personClass = Class.forName("com.ds.reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Выводим все методы класса
        Method[] personClassMethods = personClass.getMethods();
        for (Method personMethod : personClassMethods) {
            System.out.println("method_name=" + personMethod.getName()
                    + ", return_type=" + personMethod.getReturnType()
                    + ", params =" + Arrays.toString(personMethod.getParameterTypes()));
        }

        //Выводим все поля
        Field[] personClassFields = personClass.getFields(); // получить поля(поддерживается инкапсуляция)

        personClassFields = personClass.getDeclaredFields(); // получить абсолютно все поля(даже приватные)
        for (Field personClassField : personClassFields) {
            System.out.println("name=" + personClassField.getName() + " "
                    + "type=" + personClassField.getType());
        }

        //Получаем аннотации
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) System.out.println("Yes");
        }


        /* Что еще можно делать с помощью рефлексии? */

        /*                  Для обьекта класса Class                     */
        // (1) Создавать обьекты класса с помощью newInstance() (deprecated) (Также можно вызывать
        //                                                                      на обьектах класса конструктор)
        // (2) Получать методы по сигнатуре getMethods()
        // (3) Получать конструктор по сигнатуре getConstructor()

        /*                  Для обьекта класса Method                    */
        // Вызывать методы с помощью invoke()
        //
        // и многое другое


        /*"Сигнатура метода"*/// это в терминах рефлексии это НАЗВАНИЕ и НАБОР ТИПОВ ПАРАМЕТРОВ метода.

        /*Получаем методы по сигнатуре*/
        try {
            Method methodGetName = personClass.getMethod("getName");
            System.out.println("Метод " + methodGetName.getName() + " был получен" );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
