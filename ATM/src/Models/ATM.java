package Models;

public class ATM {
    public Bank OwnerBank;
    private float AmountBalanceInATM;
    private String password;
    public String Area;

    String getPassword(){
        return password;
    }

    void DepositAmount(float depositAmount) {
        this.AmountBalanceInATM += depositAmount;
    }

    void withdrawAmount(float amountToWithdraw){
        this.AmountBalanceInATM-=amountToWithdraw;
    }
    float getAmountBalanceInATM(){
        return AmountBalanceInATM;
    }

}
