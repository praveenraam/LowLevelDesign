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

}
