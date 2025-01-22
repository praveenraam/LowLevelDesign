package Models;

public class Bank {

    String name;
    float chargesForOtherBank=20.0f;

    Bank(String name){
        this.name = name;
    }
    Bank(String name,float chargesForOtherBank){
        this.name = name;
        this.chargesForOtherBank = chargesForOtherBank;
    }

    public boolean depositAmountToATM(float Amount,ATM toATM,String password){
        if(toATM.OwnerBank.equals(this) && toATM.getPassword().equals(password)){
            toATM.DepositAmount(Amount);
            System.out.println("Money successfully deposited");
            return true;
        }
        System.out.println("Money deposit process failed");
        return false;
    }

    public boolean withdrawAmount(float amount,ATM fromATM,String password){
        if(fromATM.OwnerBank.equals(this) && fromATM.getPassword().equals(password)){
            if(fromATM.getAmountBalanceInATM() < amount){
                System.out.println("Insufficient Balance");
                return false;
            }
            System.out.println("Successfully withdrawed");
            return true;
        }
        System.out.println("Money withdraw process failed");
        return false;
    }

    public float getBalanceOfATM(ATM W_ATM,String password){
        if(W_ATM.getPassword().equals(password)){
            System.out.println("The Balance Amount is "+W_ATM.getAmountBalanceInATM());
            return W_ATM.getAmountBalanceInATM();
        }
        System.out.println("Balance fetching process failed due to incorrect password");
        return 0.0f;
    }

}
