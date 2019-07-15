package com.isoft.security.user;

import java.util.ArrayList;
import java.util.List;

public enum UserRole  {
    USER, ADMIN;

    static public List<String> getEnumList(){
        List<String> enumList = new ArrayList<>();
        for (UserRole userRole : UserRole.values())
            enumList.add(userRole.toString());
        return enumList;
    }
}