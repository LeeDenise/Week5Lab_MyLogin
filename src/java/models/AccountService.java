package models;

import java.io.Serializable;

public class AccountService implements Serializable
{
    public User login(String username, String password)
    {
       User user; 
       
       if (username.equalsIgnoreCase("abe") && password.equals("password")) 
       {
           user = new User(username, password);
           return user;
       }
       
       if (username.equalsIgnoreCase("barb") && password.equals("password"))
       {
           user = new User(username, password);
           return user;
       }
       
       return null;
    }
}
