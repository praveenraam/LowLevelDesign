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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getName() {
        return name;
    }

    public void setName(Character name) {
        this.name = name;
    }

    public int getDistanceFromOrigin() {
        return distanceFromOrigin;
    }

    public void setDistanceFromOrigin(int distanceFromOrigin) {
        this.distanceFromOrigin = distanceFromOrigin;
    }

    @Override
    public String toString() {
        return
            "Location : " +
            name
            ;
    }
}
