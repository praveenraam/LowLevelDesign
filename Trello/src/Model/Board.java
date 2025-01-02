package Model;

import java.util.HashMap;
import java.util.HashSet;

public class Board extends Template {

    boolean isPrivate = false;
    String url;
    HashSet<Lists> ListSet = new HashSet<>();
    HashSet<User> User = new HashSet<>();

    public Board(int ID,String name,boolean isPrivate,String url){
        super(ID,name);
        this.isPrivate = isPrivate;
        this.url = url;
    }
    public Board(int ID,String name,String url){
        super(ID,name);
        this.url = url;
    }

    static HashMap<String,Board> BoardsTracker = new HashMap<>();

}
