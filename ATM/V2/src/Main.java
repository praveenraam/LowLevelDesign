import Models.ATM;

public class Main {
    public static void main(String[] args) {

        ATM atm = new ATM("YesBank","yesbank_1");
        atm.newProcessor.startMachine();

    }
}