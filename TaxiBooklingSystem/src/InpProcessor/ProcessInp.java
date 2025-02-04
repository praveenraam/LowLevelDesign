package InpProcessor;

import static Model.Methods.*;
import java.util.Scanner;

public class ProcessInp {

    static Scanner inputGetter = new Scanner(System.in);

    public static void start(){

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

            }
            else if(bookingOrDetails == 2){

            }
            else if(bookingOrDetails == 3){

            }
            else System.out.println();
        }

    }

}
