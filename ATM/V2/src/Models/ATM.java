package Models;

import Services.ProcessInp;

import java.util.HashMap;

public class ATM {
    String bankName;
    private float amountInATM;
    private String password;
    public ProcessInp newProcessor;
    public ATM currentATM = this;
    public static HashMap<ProcessInp,ATM> allATMMap = new HashMap<>();
    public ATM(String bankName, String password){
        this.bankName = bankName;
        this.password = password;
        amountInATM = 0.0f;
        newProcessor = new ProcessInp();
        allATMMap.put(newProcessor,this);
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void updateAmount(float FillingAmount){
        amountInATM+=FillingAmount;
    }
    public float getAmountInATM(){
        return amountInATM;
    }
}
