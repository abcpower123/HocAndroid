package com.aszqsc.hocactivitiy;

import java.util.ArrayList;
import java.util.List;

public class CheckLogin {
   private List<User> listAccount;
   CheckLogin(){
       listAccount=new ArrayList<>();
       listAccount.add(new User("abcpower123","suhao123" ));
       listAccount.add(new User("aszqsc","suhao123" ));
       listAccount.add(new User("admin","admin" ));
       listAccount.add(new User("user1","user1" ));

   }
    public boolean check(String username,String password){
        for (User u:listAccount) {
            if (u.username.equals(username)&&u.Password.equals(password))
                return true;
        }
        return false;
    }
}
