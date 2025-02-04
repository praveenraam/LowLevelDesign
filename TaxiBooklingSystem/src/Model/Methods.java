package Model;

import java.util.HashSet;

public class Methods {
    public static HashSet<Taxi> taxiSet = new HashSet<>();
    public static void createTaxi(int numberOfTaxi){
        for(int iter=0;iter<numberOfTaxi;iter++){
            Taxi newOne = new Taxi(iter+1);
            taxiSet.add(newOne);
        }
    }

    public static void display(){

    }

}
