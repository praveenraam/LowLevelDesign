package Model;

import Data.Data;

public class Cab {

    private Long id;
    private Location currLocation;

    public Cab(Location currLocation){
        this.id = Data.cabCount++;
        this.currLocation = currLocation;

        Data.cabArrayList.add(this);
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

    @Override
    public String toString() {
        return ""+id;
    }
}
