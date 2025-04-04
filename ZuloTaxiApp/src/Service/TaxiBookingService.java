package Service;

import Data.Data;
import Model.Cab;
import Model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Data.Data.cabArrayList;
import static Data.Data.locationArrayList;

public class TaxiBookingService {

    public HashMap<Location, List<Cab>> getTaxiLocation(){
        HashMap<Location, List<Cab>> track = new HashMap<>();

        for(Cab cab : Data.cabArrayList){
            if(!track.containsKey(cab.getCurrLocation())){
                track.put(cab.getCurrLocation(),new ArrayList<>());
            }
            track.get(cab.getCurrLocation()).add(cab);
        }
        return track;
    }

    public Location findLocation(Character ch){
        for(Location location : locationArrayList){
            if(location.getName() == ch) return location;
        }
        return null;
    }

    public Cab findNearestCab(Location location){

        int idx = 0;
        for(int iter=0;iter< locationArrayList.size();iter++){
            if(location.getName().equals(locationArrayList.get(iter).getName())){
                idx = iter;
                break;
            }
        }

        HashMap<Location, List<Cab>> trackMap = getTaxiLocation();

        int p1 = idx; int p2 = idx;
        while(p1>=0 || p2 < locationArrayList.size()){

            Location location1 = null;
            if(p1>=0) location1 = locationArrayList.get(p1);

            Location location2 = null;
            if(p2 < locationArrayList.size()) location2 = locationArrayList.get(p2);

            if(location1 != null && trackMap.get(location1) != null) {
                return findLowCountCab(trackMap.get(location1));
            }
            if(location2 != null && trackMap.get(location2) != null) {
                return findLowCountCab(trackMap.get(location2));
            }

            p1--; p2++;
        }

        return null;
    }

    public Cab findLowCountCab(List<Cab> cabListInLocation){
        Cab cab = cabListInLocation.get(0);
        for(int iter=1;iter<cabListInLocation.size();iter++){
            Cab currCab = cabListInLocation.get(iter);
            if(cab.getCountOfRides() > currCab.getCountOfRides()){
                if(!currCab.getLastRide())
                    cab = cabListInLocation.get(iter);
            }
        }
        return cab;
    }

    public void falseToAllTaxiRide(){
        for(Cab cab : cabArrayList){
            cab.setLastRide(false);
        }
    }

}
