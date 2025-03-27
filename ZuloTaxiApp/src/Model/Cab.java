package Model;

import Data.Data;

public class Cab {

    private Long id;
    private Long countOfRides;
    private Location currLocation;
    private Boolean isLastRide = false;

    public Cab(Location currLocation){
        this.id = Data.cabCount++;
        this.currLocation = currLocation;

        Data.cabArrayList.add(this);
    }

    public Boolean getLastRide() {
        return isLastRide;
    }

    public void setLastRide(Boolean lastRide) {
        isLastRide = lastRide;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    public Long getCountOfRides() {
        return countOfRides;
    }

    public void setCountOfRides(Long countOfRides) {
        this.countOfRides = countOfRides;
    }

    @Override
    public String toString() {
        return ""+id;
    }
}
