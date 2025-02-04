package InpProcessor;

import java.util.Scanner;

public class ProcessInp {

    static Scanner inputGetter = new Scanner(System.in);

    public static void start(){

        String bookingOrDetailsContent = "1 to book taxi\n2 to view Details\n";
        System.out.print(bookingOrDetailsContent);

        int bookingOrDetails = inputGetter.nextInt();

        if(bookingOrDetails == 1){


        }
        else if(bookingOrDetails == 2){


        }
        else System.out.println();

    }

}
