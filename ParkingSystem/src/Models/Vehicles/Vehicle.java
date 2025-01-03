package Models.Vehicles;

public class Vehicle {
    String name;
    public int costPerHour;
    public int SpotPerFloor;
    public boolean isAvaibleInFloor = true;
    public Vehicle(String name,int costPerHour,int SpotPerFloot){
        this.name = name;
        this.costPerHour = costPerHour;
        this.SpotPerFloor = SpotPerFloot;
    }
}
