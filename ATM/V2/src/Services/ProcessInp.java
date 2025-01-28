package Services;

import Models.*;

import java.util.Scanner;

public class ProcessInp {
    Scanner inputGather = new Scanner(System.in);
    Account currAccount;
    ATM currATM;
    static ProcessInp instance =  new ProcessInp();
    private ProcessInp(){}
    public static ProcessInp getInstance(){
        return instance;
    }

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
                    LoginInputProcess();
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
                if(FillAmountByBankLogin()){

                }
                else System.out.println("Enter the password Correct");
            }
            else System.out.println("Enter valid number");
        }
    }
    public void LoginInputProcess(){

        while(true){
            String LoginOutput = "Menu\n - For deposit press 1 \n - For withdrawal press 2\n - For changing pin press 3\n - For getting balance press 4\n - For logout press 5\n Enter : ";
            System.out.print(LoginOutput);

            int loginInput = inputGather.nextInt();
            inputGather.nextLine();

            if(loginInput == 1){
                String depositOutput = " - Enter the amount : ";
                System.out.println(depositOutput);
                float amountToDeposit = inputGather.nextFloat();
                inputGather.nextLine();

                currAccount.depositAmount(amountToDeposit);
                System.out.println(amountToDeposit +"is added successfully");

            }
            else if(loginInput == 2){
                String withdrawOutput = " - Enter the amount : ";
                System.out.println(withdrawOutput);
                float amountToWithdraw = inputGather.nextFloat();
                inputGather.nextLine();

                if(currAccount.withdrawAmount(amountToWithdraw))
                {
                    System.out.println(amountToWithdraw +"is withdrawn successfully");
                }
                else {
                    System.out.println("Insufficient Balance");
                }
            }
            else if(loginInput == 3){
                String changePinOutput = " - Enter the current Pin : ";
                System.out.println(changePinOutput);
                int currPin = inputGather.nextInt();
                inputGather.nextLine();

                if(currAccount.checkPin(currPin)){
                    String newPinOutput = " - Enter the new Pin : ";
                    System.out.println(newPinOutput);
                    int newPin = inputGather.nextInt();
                    inputGather.nextLine();

                    currAccount.setPin(newPin);
                    System.out.println();
                }
                else System.out.println("Wrong Current Pin");

            }
            else if(loginInput == 4){
                System.out.println("Current Account Balance is "+ currAccount.getAccountBalance());
            }
            else if(loginInput == 5){
                String logoutOutput = "Logout successful";
                System.out.println(logoutOutput);
                currAccount.changeLogout();
                currAccount = null;
                return;
            }
            else System.out.println("Enter the valid number");
        }
    }
    public void ATMmoneyDepositProcess(){
        while(true){
            String ATMDepositInput = "Menu\n - Press 1 for Filling money\n - Press 2 for getting balance\n - Press 3 for Logout";
            System.out.println(ATMDepositInput);

            int nextInput = inputGather.nextInt();
            inputGather.nextLine();


            if(nextInput == 1){
                String depositOutput = " - Enter the amount : ";
                System.out.println(depositOutput);
                float fillingAmount = inputGather.nextFloat();
                inputGather.nextLine();


                currATM.updateAmount(fillingAmount);
                System.out.println("Amount Added successfully");
            }
            else if(nextInput == 2){
                System.out.println(currATM.getAmountInATM());
            }
            else if(nextInput == 3){
                currATM = null;
                System.out.println("Logout Successfully");
            }
            else System.out.println("Enter the valid number");
        }
    }


    private boolean LoginExecution(){
        System.out.print("Enter Account NO : ");
        int AccountNo = inputGather.nextInt();
        inputGather.nextLine();

        System.out.print("\nEnter the Pin : ");
        int pinEntered = inputGather.nextInt();
        inputGather.nextLine();

        if(Account.allAccountIdMap.containsKey(AccountNo))  currAccount = Account.allAccountIdMap.get(AccountNo);
        else return false;

        if(currAccount.checkPin(pinEntered)){
            System.out.println();
            return true;
        }
        return false;
    }
    private boolean CreateAccount(){
        System.out.print("Enter your name : ");
        String userName = inputGather.nextLine();

        System.out.print("\nEnter your Pan Number : ");
        String panNo = inputGather.nextLine();

        System.out.print("\nEnter 4 Digit Pin : ");
        int pin = inputGather.nextInt();
        inputGather.nextLine();

        Account newAccount = new Account(userName,pin,panNo);
        if(Account.allAccountIdMap.containsKey(newAccount.accountNO)){
            System.out.println("Your Account Number : "+newAccount.accountNO);
            return true;
        }
        return false;
    }
    private boolean FillAmountByBankLogin(){
        System.out.print("Enter the password : ");
        String password = inputGather.nextLine();

        currATM = ATM.allATMMap.get(this);
        if(currATM.checkPassword(password)){
            ATMmoneyDepositProcess();
            return true;
        }
        return false;
    }

}
