package com.ds.annotation.simpleimpl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Danil on 08.12.2022
 * @project JavaCoreLearning
 *
 * Аннотация для проверки прав
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRequired {
    User.Permission value();
}
