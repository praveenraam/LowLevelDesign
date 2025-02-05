package InpProcessor;

import Model.Methods;

import static Model.Methods.*;
import java.util.Scanner;

public class ProcessInp {

    // Singleton Class
    static ProcessInp processor = new ProcessInp();
    private ProcessInp(){

    };
    public static ProcessInp getInstance(){
        return processor;
    }

    Scanner inputGetter = new Scanner(System.in);
    public void start(){

        String taxiCount = "Enter the number of Taxi : ";
        System.out.print(taxiCount);

        int numberOfTaxi = inputGetter.nextInt();
        createTaxi(numberOfTaxi);
        inputGetter.nextLine();

        while(true){
            String bookingOrDetailsContent = "1 to book taxi\n2 to view Details\n3 to Exit\n";
            System.out.print(bookingOrDetailsContent);

            int bookingOrDetails = inputGetter.nextInt();

            if(bookingOrDetails == 1){
                String bookingInputs = "Enter Customer ID : ";
                System.out.print(bookingInputs);
                int customerID = inputGetter.nextInt();
                inputGetter.nextLine();

                bookingInputs = "Enter the Pickup Point : ";
                System.out.print(bookingInputs);
                char pickupPoint = inputGetter.next().charAt(0);

                bookingInputs = "Enter the drop Point : ";
                System.out.println(bookingInputs);
                char dropPoint = inputGetter.next().charAt(0);

                bookingInputs = "Enter the Pickup Time : ";
                System.out.println(bookingInputs);
                int pickupTime = inputGetter.nextInt();

                Methods.bookTaxi(customerID,pickupTime,pickupPoint,dropPoint);
            }
            else if(bookingOrDetails == 2){
                Methods.display();
            }
            else if(bookingOrDetails == 3){
                break;
            }
            else System.out.println("Enter valid input\n");
        }

    }

}
