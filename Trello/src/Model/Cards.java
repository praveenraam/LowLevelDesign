package Model;

import java.util.HashMap;
import java.util.HashSet;

public class Cards extends Template {

    String Description;
    Lists currList;
    HashSet<User> UserList = new HashSet<>();

    public Cards(int ID,String name,String Description){
        super(ID,name);
        this.Description = Description;
    }

    static HashMap<String, Cards> CardsTracker = new HashMap<>();

}
