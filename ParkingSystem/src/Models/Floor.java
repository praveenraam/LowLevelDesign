package Models;

import Models.Vehicles.Vehicle;

import java.util.HashSet;

public class Floor {
    int FloorNo;
    Vehicle Bike;
    Vehicle Car;
    Vehicle Truck;

    HashSet<ParkingSpot> BikeLotAvailability = new HashSet<>();
    HashSet<ParkingSpot> CarLotAvailability = new HashSet<>();
    HashSet<ParkingSpot> TruckLotAvailability = new HashSet<>();

    public Floor(int FloorNo,Vehicle Car,Vehicle Bike,Vehicle Truck){
        this.FloorNo = FloorNo;
        this.Car = Car;
        this.Bike = Bike;
        this.Truck = Truck;

        AllocateResource();
    }

    private void AllocateResource(){
        for(int iter=1;iter<=Bike.SpotPerFloor;iter++){
            BikeLotAvailability.add(new ParkingSpot(iter));
        }
        for(int iter=1;iter<=Car.SpotPerFloor;iter++){
            CarLotAvailability.add(new ParkingSpot(iter));
        }
        for(int iter=1;iter<=Truck.SpotPerFloor;iter++){
            TruckLotAvailability.add(new ParkingSpot(iter));
        }
    }

    public HashSet<ParkingSpot> getAvailabilitySet(String VehicleType){
        if(VehicleType.equals("Bike")){
            return BikeLotAvailability;
        }
        else if(VehicleType.equals("Car")){
            return CarLotAvailability;
        }
        else return TruckLotAvailability;
    }
    public int DisplayTypeAvailable(String Type){
        int count = 0;
        for(ParkingSpot parkingSpot : this.getAvailabilitySet(Type)){
            if(parkingSpot.getAvailableToPark()) count++;
        }
        return count;
    }
}
