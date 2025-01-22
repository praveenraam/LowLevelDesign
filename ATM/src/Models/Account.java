package Models;

public class Account {
    public Bank AccountBank;
    public int AccountNO;

    private String Password;
    private String email;
    private float AccountBalance;
    String PhoneNo;
    private boolean isLogged;

    boolean VerifyAccountPassword(String passwordInp){
        return passwordInp.equals(Password);
    }


}
