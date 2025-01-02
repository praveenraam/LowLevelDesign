package Model;

import java.util.HashMap;

public class User extends Template {
    String email;

    Board CurrBoard;
    Lists CurrList;
    public User(int ID,String name,String email){
        super(ID,name);
        this.email = email;
    }


    static HashMap<String,User> UsersMap = new HashMap<>();

}
