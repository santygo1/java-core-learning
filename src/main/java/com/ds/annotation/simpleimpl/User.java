package com.ds.annotation.simpleimpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil on 08.12.2022
 * @project JavaCoreLearning
 */
public class User {

    public enum Permission{
        USER_MANAGEMENT, CONTENT_MANAGEMENT
    }

    List<Permission> permissions;

    public List<Permission> getPermissions(){
        return new ArrayList<>(permissions);
    }
}
