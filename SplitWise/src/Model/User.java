package Model;

import java.util.HashMap;
import java.util.HashSet;

public class User extends Tracker {
    int userID;
    String Name;
    String Email;
    String MobileNo;

    public User(int userID,String Name,String Email,String MobileNo){
        this.userID = userID;
        this.Name = Name;
        this.Email = Email;
        this.MobileNo = MobileNo;
    }

    public void addExpend(MoneyMapped[] Arr){
        for(MoneyMapped var : Arr){
            if(!ExpenseLendContains(var.user)){
                setExpenseLent(var.user,0f);
            }
            float AlreadyLent = getAlreadyLentAmount(var.user);
            setExpenseLent(var.user,AlreadyLent+ var.money);
        }
    };


    public static void ShowAllExpense(){
        for(Integer userId : UserTracker.keySet()){
            User user = UserTracker.get(userId);
            HashMap<User,Float> ExpenseLentHashMap = user.getExpenseLent();

            if(ExpenseLentHashMap.isEmpty()) {
                System.out.println("No Balances");
                continue;
            }

            for(User MoneyBorrower : ExpenseLentHashMap.keySet()){
                System.out.print("u"+userId+" owes User"+ MoneyBorrower.userID+":");
                System.out.printf("%.0f",ExpenseLentHashMap.get(MoneyBorrower));
                System.out.println();
            }

        }
    }

    public void SpecificUserExpense(){
        HashMap<User,Float> ExpenseLentHashMap = getExpenseLent();

        if(ExpenseLentHashMap.isEmpty()) {
            System.out.println("No Balances");
            return;
        }

        for(User MoneyBorrower : ExpenseLentHashMap.keySet()){
            System.out.print("u"+userID+" owes User"+ MoneyBorrower.userID+":");
            System.out.printf("%.0f",ExpenseLentHashMap.get(MoneyBorrower));
            System.out.println();
        }
    }

    private static HashMap<Integer,User> UserTracker =  new HashMap<>();
    public static void addToTracker(int UserId,User user){
        UserTracker.put(UserId,user);
    }
    public static HashMap<Integer,User> getUserTracker(){
        return UserTracker;
    }
}
