package com.isoft.security.user;

import java.util.List;

public class UserRoleTest {

    public static void main(String[] args){
            System.out.println(UserRole.getEnumList().get(0));
    }

    public static List<String> getRoleList(){
        return UserRole.getEnumList();
    }
}
