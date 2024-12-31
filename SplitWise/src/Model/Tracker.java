package Model;

import java.util.HashMap;

public class Tracker {
    private final HashMap<User,Float> ExpenseLent = new HashMap<>();

    protected HashMap<User,Float> getExpenseLent(){
        return ExpenseLent;
    }
    protected void setExpenseLent(User user, float money){
        ExpenseLent.put(user,money);
    };
    protected boolean ExpenseLendContains(User user){
        return ExpenseLent.containsKey(user);
    }
    protected float getAlreadyLentAmount(User user){
        return ExpenseLent.get(user);
    }
    protected void removeFromExpense(User user){
        if(ExpenseLendContains(user)){
            ExpenseLent.remove(user);
        }
    }
}

