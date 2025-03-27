package Model;
import Data.Data;

public class Location {

    private Integer id;
    private Character name;
    private int distanceFromOrigin;

    public Location(Integer id,Character name,int distanceFromOrigin){
        this.id = id;
        this.name = name;
        this.distanceFromOrigin = distanceFromOrigin;

        Data.locationCount++;
        Data.locationArrayList.add(this);
    }


}
