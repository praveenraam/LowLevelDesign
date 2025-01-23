package Models;
import java.util.HashMap;
import java.util.HashSet;

public class Bank {
    static HashSet<Bank> AllBankSet = new HashSet<>();
    HashSet<ATM> ATMsBankList = new HashSet<>();
    HashMap<Integer,Account> BanksAccountIdMap = new HashMap<>();
    String name;
    float chargesForOtherBank=20.0f;
    public Bank(String name){
        this.name = name;
        AllBankSet.add(this);
    }
    public Bank(String name,float chargesForOtherBank){
        this.name = name;
        this.chargesForOtherBank = chargesForOtherBank;
        AllBankSet.add(this);
    }

    public String depositAmountToATM(float Amount,ATM toATM,String password){
        if(toATM.OwnerBank.equals(this) && toATM.VerifyPassword(password)){
            toATM.DepositAmountToATM(Amount);
            return "Money successfully deposited";
        }
        return "Money deposit process failed";
    }

    public String withdrawAmount(float amount,ATM fromATM,String password){
        if(fromATM.OwnerBank.equals(this) && fromATM.VerifyPassword(password)){
            if(fromATM.getAmountBalanceInATM() < amount){
                return "Insufficient Balance";

            }
            return  "Successfully withdrawed";
        }
        return "Money withdraw process failed";
    }

    public String getBalanceOfATM(ATM W_ATM,String password){
        if(W_ATM.VerifyPassword(password)){
            return "The Balance Amount is "+W_ATM.getAmountBalanceInATM();
        }
        return "Balance fetching process failed due to incorrect password";
    }

}
