package com.ds.annotation.simpleimpl;

/**
 * @author Danil on 08.12.2022
 * @project JavaCoreLearning
 */
@PermissionRequired(User.Permission.USER_MANAGEMENT)
public class UserDeleteAction {
    void invoke(User user){
        
    }
}
