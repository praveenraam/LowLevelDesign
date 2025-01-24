package Services;

import java.util.Scanner;

public class ProcessInp {
    static Scanner inputGather = new Scanner(System.in);

    static public void startMachine(){
        while(true){

            String FirstOutput = " - For Login press 1 \n - For Creating Account press 2\n - For Deposit From Bank press 3";
            System.out.println(FirstOutput);

            int firstInput = inputGather.nextInt();
            inputGather.nextLine();

            if(firstInput == 1){

                if(LoginExecution()){

                }
                else System.out.println("Login failed : Wrong Creadentials");

            }
            else if(firstInput == 2){

                if(CreateAccount()){

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

    private static boolean LoginExecution(){
        System.out.print("Enter Account NO : ");
        String AccountNO = inputGather.nextLine();
        System.out.print("\nEnter the password : ");
        String passwordEntered = inputGather.nextLine();

        if(1>1)
            return true;

        return false;
    }

    private static boolean CreateAccount(){
        System.out.print("Enter your name : ");
        String Name = inputGather.nextLine();
        System.out.print("\nEnter your Pan Number : ");
        String PanNO = inputGather.nextLine();
        System.out.print("\nEnter your Mobile Number : ");
        String MobileNO = inputGather.nextLine();

        if(1>1)
            return true;

        return false;
    }

    private static boolean DepositAmountByBankLogin(){
        System.out.print("Enter the password : ");
        String password = inputGather.nextLine();
        if(1>1) return true;
        return false;
    }

}
