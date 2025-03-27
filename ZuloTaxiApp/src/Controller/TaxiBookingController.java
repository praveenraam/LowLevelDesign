package Controller;

import Model.Cab;
import Model.Location;
import Service.TaxiBookingService;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaxiBookingController {

    private Scanner in = new Scanner(System.in);
    private TaxiBookingService taxiBookingService = new TaxiBookingService();

    public void startBookingTaxi(){

            HashMap<Location,List<Cab>> trackingMap = taxiBookingService.getTaxiLocation();

            for(Location location : trackingMap.keySet()){
                System.out.println("location : "+location+"\nCabs : "+trackingMap.get(location));
            }

            System.out.println("Enter the Source : ");
            Character sourceChar = in.next().charAt(0);
            System.out.println("Enter the Destination");
            Character destinationChar = in.next().charAt(0);

            Location sourceLoc = taxiBookingService.findLocation(sourceChar);
            Location destinationLoc = taxiBookingService.findLocation(destinationChar);

            Cab cab = taxiBookingService.findNearestCab(sourceLoc);

            int distance = Math.abs(sourceLoc.getDistanceFromOrigin()-destinationLoc.getDistanceFromOrigin());
            int totalFair = distance*10;

            System.out.println("Cab allotted : " +cab.getId());
            System.out.println("Fair for Travel : "+totalFair);

            System.out.println("To confirm enter 1\nTo cancel enter 2\n : ");

            int val = in.nextInt();
            in.nextLine();

            if(val == 1){
                System.out.println("Your travel confirmed");
                taxiBookingService.falseToAllTaxiRide();
                cab.setLastRide(true);
            }
            else
                System.out.println("Your travel cancelled");
    }



}
