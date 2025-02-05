package Model;

import java.util.HashMap;
import java.util.HashSet;

public class Methods {
    public static HashSet<Taxi> taxiSet = new HashSet<>();
    public static HashMap<Taxi,HashSet<History>> taxiBookedHistory = new HashMap<>();
    public static int noOfBooking = 0;
    public static void createTaxi(int numberOfTaxi){
        for(int iter=0;iter<numberOfTaxi;iter++){
            Taxi newOne = new Taxi(iter+1);
            taxiSet.add(newOne);
        }
    }

    public static void bookTaxi(int customerID,int pickupTime,char pickupPoint,char dropPoint){
        Taxi taxiForPicking = null;
        int minDistance = Integer.MAX_VALUE;

        for(Taxi taxi : taxiSet){
            if(taxi.getDrop_time() <= pickupTime && Math.abs(pickupPoint-taxi.getCurrent_position()) <= minDistance){
                if(Math.abs(pickupPoint-taxi.getCurrent_position()) == minDistance){
                    if(taxiForPicking != null && taxiForPicking.getEarnings() < taxi.getEarnings()){
                        taxiForPicking = taxi;
                    }
                }
                else{
                    taxiForPicking = taxi;
                    minDistance = Math.abs(pickupPoint-taxi.getCurrent_position());
                }
            }
        }

        if(taxiForPicking == null){
            System.out.println("Taxi is not Available");
        }
        else{
            System.out.println(taxiForPicking.taxiID);
            noOfBooking++;

            // Customer ID
            taxiForPicking.setCustomerID(customerID);

            // Changing currPosition to Drop Point
            taxiForPicking.setCurrent_position(dropPoint);

            // Pickup point and time
            taxiForPicking.setPick_up_position(pickupPoint);
            taxiForPicking.setPickUp_time(pickupTime);

            // Drop point and time
            taxiForPicking.setDestiny_position(dropPoint);

            int travelTime = Math.abs(pickupPoint - dropPoint);
            int dropTime = pickupTime + travelTime;
            taxiForPicking.setDrop_time(dropTime);

            // Earnings
            int kmTravelled = Math.abs(pickupPoint-dropPoint)*15;
            int earnings = ((kmTravelled-5)*10)+(100);
            taxiForPicking.setEarnings(earnings+taxiForPicking.getEarnings());

            HashSet<History> taxiHistory = taxiBookedHistory.getOrDefault(taxiForPicking,new HashSet<>());
            taxiHistory.add(new History(noOfBooking,customerID,pickupPoint,dropPoint,pickupTime,dropTime,earnings));
            taxiBookedHistory.put(taxiForPicking,taxiHistory);
        }
    }

    public static void display(){
        for(Taxi taxi : taxiBookedHistory.keySet()){
            System.out.println("Taxi No : "+taxi.taxiID +"  Total Earnings: Rs."+taxi.getEarnings());

            for(History history: taxiBookedHistory.get(taxi)){

                System.out.print(history.getBookingID()+"     ");
                System.out.print(history.getCustomerID()+"     ");
                System.out.print(history.getFrom()+"     ");
                System.out.print(history.getTo()+"     ");
                System.out.print(history.getPickupTime()+"     ");
                System.out.print(history.getDropTime()+"     ");
                System.out.println(history.getCharges()+"     ");
            }
        }
    }
}
