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
            if(var.user.userID == userID) continue;
            if(!ExpenseLendContains(var.user)){
                setExpenseLent(var.user,0f);
            }
            float AlreadyLent = getAlreadyLentAmount(var.user);
            AverageTheExpense(var.user,AlreadyLent+ var.money);
        }
    };


    public static void ShowAllExpense(){
        boolean isAllEmpty = true;
        for(Integer userId : UserTracker.keySet()){
            User user = UserTracker.get(userId);
            HashMap<User,Float> ExpenseLentHashMap = user.getExpenseLent();

            if(ExpenseLentHashMap.isEmpty()) {
                continue;
            }
            isAllEmpty = false;
            for(User MoneyBorrower : ExpenseLentHashMap.keySet()){
                if(ExpenseLentHashMap.get(MoneyBorrower) == 0) continue;
                System.out.print("user"+MoneyBorrower.userID +" owes User" +userId+": ");
                System.out.printf("%.0f",ExpenseLentHashMap.get(MoneyBorrower));
                System.out.println();
            }

        }
        if(isAllEmpty) System.out.println("No Balances");
    }

    public void SpecificUserExpense(){
        HashMap<User,Float> ExpenseLentHashMap = getExpenseLent();

        if(ExpenseLentHashMap.isEmpty()) {
            System.out.println("No Balances");
            return;
        }

        for(User MoneyBorrower : ExpenseLentHashMap.keySet()){
            if(ExpenseLentHashMap.get(MoneyBorrower) == 0) continue;
            System.out.print("user"+MoneyBorrower.userID +" owes User" +userID+": ");
            System.out.printf("%.0f",ExpenseLentHashMap.get(MoneyBorrower));
            System.out.println();
        }
    }

    public void AverageTheExpense(User user,float currLendingAmount){
        User currLender = UserTracker.get(userID);
        float amountAlreadyBorrowed = 0;
        if(user.ExpenseLendContains(currLender)){
            amountAlreadyBorrowed = user.getAlreadyLentAmount(currLender);
        }
        if(currLendingAmount == amountAlreadyBorrowed){
            user.setExpenseLent(currLender,0f);
        }
        else if(currLendingAmount < amountAlreadyBorrowed){
            user.setExpenseLent(currLender,amountAlreadyBorrowed-currLendingAmount);
        }
        else{
            currLender.setExpenseLent(user,currLendingAmount-amountAlreadyBorrowed);
            user.removeFromExpense(currLender);
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
