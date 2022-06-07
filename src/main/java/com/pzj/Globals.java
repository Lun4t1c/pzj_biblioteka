package com.pzj;

import dao.DataAccess;
import models.EmployeeModel;
import models.UserInfoModel;

public class Globals {

    private static UserInfoModel loggedUser;
    private static boolean isEmployee = false;

    public static UserInfoModel getLoggedUser(){
        return loggedUser;
    }
    public static void setLoggedUser(UserInfoModel loggedUser){
        loggedUser = loggedUser;

        if (loggedUser instanceof EmployeeModel) isEmployee = true;
    }

    public static boolean getIsLoggedUserEmployee(){
        return isEmployee;
    }
}
