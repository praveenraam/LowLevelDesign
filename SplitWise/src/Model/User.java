package Model;

import javax.sql.rowset.BaseRowSet;
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

        for(Integer userId : UserTracker.keySet()){
            HashMap<User,Float> BorrowedAmounts = new HashMap<>();
            for(Integer IteruserID : UserTracker.keySet()){
                User LentUser = UserTracker.get(IteruserID);
                User BorrowedUser = UserTracker.get(userId);
                float amount = 0f;
                if(LentUser.ExpenseLendContains(BorrowedUser)){
                    amount = LentUser.getAlreadyLentAmount(BorrowedUser);
                }
                if(amount != 0f){
                    BorrowedAmounts.put(LentUser,amount);
                }
            }
            if(BorrowedAmounts.isEmpty()) {
                continue;
            }
            isAllEmpty = false;
            for(User user : BorrowedAmounts.keySet()){
                System.out.print("user"+userId+" owes User"+user.userID+": ");
                System.out.printf("%.0f",BorrowedAmounts.get(user));
                System.out.println();
            }

        }
        if(isAllEmpty) System.out.println("No Balances");

    }

    public void SpecificUserExpense(){
        HashMap<User,Float> ExpenseLentHashMap = getExpenseLent();
        boolean isBorrowed = false;
        HashMap<User,Float> BorrowedAmounts = new HashMap<>();

        for(Integer IteruserID : UserTracker.keySet()){
            User LentUser = UserTracker.get(IteruserID);
            User BorrowedUser = UserTracker.get(this.userID);
            float amount = 0f;
            if(LentUser.ExpenseLendContains(BorrowedUser)){
                amount = LentUser.getAlreadyLentAmount(BorrowedUser);
                isBorrowed = true;
            }
            if(amount != 0f){
                BorrowedAmounts.put(LentUser,amount);
            }
        }

        if(ExpenseLentHashMap.isEmpty() && (!isBorrowed)) {
            System.out.println("No Balances");
            return;
        }

        for(User MoneyBorrower : ExpenseLentHashMap.keySet()){
            if(ExpenseLentHashMap.get(MoneyBorrower) == 0) continue;
            System.out.print("user"+MoneyBorrower.userID +" owes User" +this.userID+": ");
            System.out.printf("%.0f",ExpenseLentHashMap.get(MoneyBorrower));
            System.out.println();
        }
        for(User user : BorrowedAmounts.keySet()){
            System.out.print("user"+this.userID+" owes User"+user.userID+": ");
            System.out.printf("%.0f",BorrowedAmounts.get(user));
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
