package Model;

import Data.Data;

import java.util.ArrayList;

public class Cab {

    private Long id;
    private Long countOfRides;
    private Location currLocation;
    private Boolean isLastRide = false;
    private Driver driver;
    private ArrayList<RideDetails> rideDetailsArrayList = new ArrayList<>();

    public Cab(Location currLocation){
        this.id = Data.cabCount++;
        this.currLocation = currLocation;

        Data.cabArrayList.add(this);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public ArrayList<RideDetails> getRideDetailsArrayList() {
        return rideDetailsArrayList;
    }

    public void setRideDetailsArrayList(ArrayList<RideDetails> rideDetailsArrayList) {
        this.rideDetailsArrayList = rideDetailsArrayList;
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
