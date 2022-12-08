package com.ds.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Danil on 08.12.2022
 * @project JavaCoreLearning
 */
@Target({ElementType.METHOD, ElementType.TYPE}) //ElementType.Type - интерфейс, enum, класс
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();
    int dateOfCreation();
}
