package Models;

import java.util.HashMap;
import java.util.HashSet;

public class Account {
    private static int totalAccount = 0;
    static public HashMap<Integer,Account> allAccountIdMap = new HashMap<>();
    static HashSet<String> setForPan = new HashSet<>();
    public int accountNO;
    public String userName;
    private int pin;
    private float accountBalance;
    public String panNo;
    private boolean isLogged;

    public Account(String userName,int pin,String panNo){
        this.userName = userName;
        this.pin = pin;
        this.panNo = panNo;

        accountNO = 10000+(++totalAccount);
        accountBalance = 0f;
        isLogged = false;

        Account.allAccountIdMap.put(this.accountNO,this);
    }

    public boolean checkPin(int pin){
        return pin == this.pin;
    }
    public void setPin(int pin){
        this.pin = pin;
    }
    public void changeLogin(){
        isLogged = true;
    }
    public void changeLogout(){
        isLogged = false;
    }

    public void depositAmount(float amount){
        this.accountBalance += amount;
    }
    public boolean withdrawAmount(float amount){
        if(amount > accountBalance){
            return false;
        }
        accountBalance-=amount;
        return true;
    }
    public float getAccountBalance(){
        return accountBalance;
    }
}
