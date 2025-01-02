package Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lists extends Template {

    HashSet<Cards> CardSet = new HashSet<Cards>();

    Board currBoard;

    public Lists(int ID,String name){
        super(ID,name);
    }

    static HashMap<String, Lists> ListsTracker = new HashMap<>();

}
