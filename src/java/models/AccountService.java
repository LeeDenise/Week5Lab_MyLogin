package models;

public class AccountService 
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
       
//       if (!username.equalsIgnoreCase("abe") || !username.equalsIgnoreCase("barb"))
//       {
//           return null;
//       } else if (username.equalsIgnoreCase("abe") && password.equals("password"))
//       {
//           user = new User(username, password);
//           return user;
//       } else if (username.equalsIgnoreCase("barb") && password.equals("password"))
//       {
//           user = new User(username, password);
//           return user;
//       }
//       else 
//       {
//         return null;  
//       }
    }
}
