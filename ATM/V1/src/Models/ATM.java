package Models;

import java.util.HashSet;

public class ATM {
    static HashSet<ATM> AllATMsList = new HashSet<>();
    public Bank OwnerBank;
    private float AmountBalanceInATM;
    private String password;
    public String Area;
    private Account CurrLoggedAccount;

    public ATM(Bank OwnerBank,String password,String Area){
        this.OwnerBank = OwnerBank;
        this.password = password;
        this.Area = Area;

        this.OwnerBank.ATMsBankList.add(this);
        AllATMsList.add(this);
    }

    boolean VerifyPassword(String passwordInp){
        return password.equals(passwordInp);
    }

    void DepositAmountToATM(float depositAmount) {
        this.AmountBalanceInATM += depositAmount;
    }
    void withdrawAmountFromATM(float amountToWithdraw){
        this.AmountBalanceInATM -= amountToWithdraw;
    }
    float getAmountBalanceInATM(){
        return AmountBalanceInATM;
    }

    public String Login(Bank AccountsBank,int AccountNo,String password){
        if(AccountsBank.BanksAccountIdMap.containsKey(AccountNo)) {
            Account currAccount = AccountsBank.BanksAccountIdMap.get(AccountNo);
            if(currAccount.VerifyAccountPassword(password)) {
                currAccount.changeLogged();
                CurrLoggedAccount = currAccount;
                return "Logged In";
            }
            else return "Password entered is incorrect";
        }
        return "No Account found on the respective ";
    }
    public String Logout(){
        CurrLoggedAccount.changeLogout();
        CurrLoggedAccount = null;
        return "Logout Successfully done";
    }
    public String setPass(String newPassword){
        if(CurrLoggedAccount != null){
            CurrLoggedAccount.changePassword(newPassword);
            return "Password Changed";
        }
        else return "Login to change password";
    }
    public String getBalance(){
        if(CurrLoggedAccount != null){
            return "Balance : "+CurrLoggedAccount.getAccountBalance();
        }
        return "Login to get Balance";
    }
    public String depositAmount(float Amount){
        if(CurrLoggedAccount != null){
            CurrLoggedAccount.setAccountBalance(Amount);
            return "Amount deposited Successfully";
        }
        return "Login to deposit Balance";
    }
    public String withdrawAmount(float Amount){
        if(CurrLoggedAccount != null){
            float currBalance = CurrLoggedAccount.getAccountBalance();
            if(currBalance < Amount){
                return "Insufficient balance to withdraw";
            }
            return "Successfully withdrawed "+Amount;
        }
        return "Login to withdraw amount";
    }
}
