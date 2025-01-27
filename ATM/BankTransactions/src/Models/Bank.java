package Models;

public class Bank {
    static float balanceInBank = 12000;
    static synchronized void withdrawAmount(String name,float withdrawalAmount){

        if(balanceInBank >= withdrawalAmount){
            System.out.println(name+" withdraws "+withdrawalAmount);
            balanceInBank -= withdrawalAmount;
            System.out.println("Balance in withdrawal : "+ balanceInBank);

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println(name + ", you can't withdraw amount");
        System.out.println("Total balance in Bank is "+balanceInBank);

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    static synchronized void deposit(String name,float amountToAdd){

        System.out.println(name + " deposits "+amountToAdd);
        balanceInBank += amountToAdd;
        System.out.println("Balance after depositing : "+ balanceInBank);

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
