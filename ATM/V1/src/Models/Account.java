package Models;

import java.util.HashMap;

public class Account {
    private static int totalAccount = 0;
    static HashMap<Integer,Account> AllAccountIdMap = new HashMap<>();
    public Bank AccountBank;
    public int AccountNO;
    private String Password;
    private String email;
    private float AccountBalance;
    String PhoneNo;
    private boolean isLogged;

    public Account(Bank AccountBank,String password,String email,String PhoneNo){
        this.AccountBank = AccountBank;
        this.Password = password;
        this.email = email;
        this.PhoneNo = PhoneNo;
        this.AccountNO = ++totalAccount;
        this.AccountBalance = 0f;
        this.isLogged = false;

        AccountBank.BanksAccountIdMap.put(this.AccountNO,this);
        AllAccountIdMap.put(this.AccountNO,this);
    }

    boolean VerifyAccountPassword(String passwordInp){
        return passwordInp.equals(Password);
    }
    void changeLogged(){
        isLogged = true;
    }
    void changeLogout(){
        isLogged = false;
    }
    void changePassword(String newPassword){
        this.Password = newPassword;
    }
    float getAccountBalance(){
        return AccountBalance;
    }
    void setAccountBalance(float addedAccount){
        AccountBalance += addedAccount;
    }
}
