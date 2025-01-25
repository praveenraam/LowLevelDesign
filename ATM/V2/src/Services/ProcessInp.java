package Services;

import Models.*;
import Models.Account.*;

import java.util.Scanner;

public class ProcessInp {
    Scanner inputGather = new Scanner(System.in);
    Account currAccount;

    public void startMachine(){
        while(true){

            String FirstOutput = " - For Login press 1 \n - For Creating Account press 2\n - For Deposit From Bank press 3\n Enter : ";
            System.out.println(FirstOutput);

            int firstInput = inputGather.nextInt();
            inputGather.nextLine();

            if(firstInput == 1){

                if(LoginExecution()){
                    currAccount.changeLogin();
                    System.out.println("Logic Successful");
                }
                else System.out.println("Login failed : Wrong Creadentials");

            }
            else if(firstInput == 2){

                if(CreateAccount()){
                    System.out.println("Account created Successfully");
                }
                else System.out.println("Account Creation failed");

            }
            else if(firstInput == 3){
                if(DepositAmountByBankLogin()){

                }
                else System.out.println("Enter the password Correct");
            }
            else System.out.println("Enter valid number");
        }
    }
    public void InputProcessStart(){

        while(true){
            String LoginOutput = " - For deposit press 1 \n - For withdrawal press 2\n - For changing pin press 3\n - For getting balance press 4\n - For logout press 5\n Enter : ";
            System.out.print(LoginOutput);

            int loginInput = inputGather.nextInt();

            if(loginInput == 1){
                String depositOutput = " - Enter the amount : ";
                float amountToDeposit = inputGather.nextFloat();

                currAccount.depositAmount(amountToDeposit);
                System.out.println(amountToDeposit +"is added successfully");

            }
            else if(loginInput == 2){
                String withdrawOutput = " - Enter the amount : ";
                float amountToWithdraw = inputGather.nextFloat();

                if(currAccount.withdrawAmount(amountToWithdraw))
                {
                    System.out.println(withdrawOutput +"is withdrawn successfully");
                }
                else {
                    System.out.println("Insufficient Balance");
                }
            }
            else if(loginInput == 3){
                String changePinOutput = " - Enter the current Pin : ";
                int currPin = inputGather.nextInt();

                if(currAccount.checkPin(currPin)){
                    String newPinOutput = " - Enter the new Pin : ";
                    int newPin = inputGather.nextInt();
                    currAccount.setPin(newPin);
                    System.out.println();
                }
                else System.out.println("Wrong Current Pin");

            }
            else if(loginInput == 4){
                System.out.println("Current Account Balance is "+ currAccount.getAccountBalance());
            }
            else if(loginInput == 5){
                currAccount.changeLogout();
                currAccount = null;
            }
        }

    }


    private boolean LoginExecution(){
        System.out.print("Enter Account NO : ");
        int AccountNo = inputGather.nextInt();

        System.out.print("\nEnter the Pin : ");
        int pinEntered = inputGather.nextInt();
        inputGather.nextLine();

        if(Account.allAccountIdMap.containsKey(AccountNo))  currAccount = Account.allAccountIdMap.get(AccountNo);
        else return false;

        if(currAccount.checkPin(pinEntered)){
            System.out.println();
            InputProcessStart();
            return true;
        }
        return false;
    }
    private boolean CreateAccount(){
        System.out.print("Enter your name : ");
        String userName = inputGather.nextLine();

        System.out.print("\nEnter your Pan Number : ");
        String panNo = inputGather.nextLine();

        System.out.print("\nEnter 4 Digit Pin");
        int pin = inputGather.nextInt();
        inputGather.nextLine();

        Account newAccount = new Account(userName,pin,panNo);
        if(Account.allAccountIdMap.containsKey(newAccount.accountNO)){
            System.out.println("Your Account Number : "+newAccount.accountNO);
            return true;
        }
        return false;
    }
    private boolean DepositAmountByBankLogin(){
        System.out.print("Enter the password : ");
        String password = inputGather.nextLine();
        if(1>1) return true;
        return false;
    }

}
