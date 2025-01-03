package Models;

import Models.Vehicles.Vehicle;

import java.util.HashMap;

public class ParkingLot {
    int NoOfFloors;
    String Name;
    int totalLotsPerFloor;
    int CarLotsPerFloor;
    int TruckLotsPerFloor;
    int BikeLotsPerFloor;

    HashMap<Integer, Floor> FloorTracker = new HashMap<>();
    private Floor currFloor;

    public ParkingLot(int NoOfFloors,String name,int CarLotsPerFloor,int TruckLotsPerFloor,int BikeLotsPerFloor){
        this.NoOfFloors = NoOfFloors;
        this.Name = name;
        this.CarLotsPerFloor = CarLotsPerFloor;
        this.TruckLotsPerFloor = TruckLotsPerFloor;
        this.BikeLotsPerFloor = BikeLotsPerFloor;
        this.totalLotsPerFloor = CarLotsPerFloor+TruckLotsPerFloor+BikeLotsPerFloor;
        AllocateRequiredDS();
    }
    private void AllocateRequiredDS(){
        Vehicle Car = new Vehicle("Car",30,CarLotsPerFloor);
        Vehicle Bike = new Vehicle("Bike",20,BikeLotsPerFloor);
        Vehicle Truck = new Vehicle("Truck",50,TruckLotsPerFloor);

        for(int iter=0;iter<NoOfFloors;iter++){
                FloorTracker.put(iter,new Floor(iter,Car,Bike,Truck));
        }
    }

    public void DisplayAvailability(){
        int NoOfCarLotsAvailable = ReturnTypeAvailable("Car");
        int NoOfBikeLotAvailable = ReturnTypeAvailable("Bike");
        int NoOfTruckLotAvailable = ReturnTypeAvailable("Truck");

        System.out.println("Cars  : "+NoOfCarLotsAvailable);
        System.out.println("Bike  : "+NoOfBikeLotAvailable);
        System.out.println("Truck : "+NoOfTruckLotAvailable);
    }

    private int ReturnTypeAvailable(String Type){
        int count = 0;
        for(int CurrFloorNo : FloorTracker.keySet()){
            Floor currFloor = FloorTracker.get(CurrFloorNo);
            count+=currFloor.DisplayTypeAvailable(Type);
        }
        return count;
    }
    public void DisplayTypeAvailable(String Type){
        System.out.println(Type+" : "+ReturnTypeAvailable(Type));
    }

    public void ParkVehicle(String VehicleType,String VehicleNo){
        for(int CurrFloorNo : FloorTracker.keySet()){
            Floor currFloor = FloorTracker.get(CurrFloorNo);
            for(ParkingSpot parkingSpot : currFloor.getAvailabilitySet(VehicleType)){
                if(parkingSpot.getAvailableToPark()){
                    parkingSpot.addToParking(VehicleNo);
                    System.out.println("Vehicle is be parked at floor no "+currFloor.FloorNo+" in at "+VehicleType+" slot No : "+parkingSpot.SpotNumber);
                    return;
                };
            }
        }
        System.out.println("No Parking Space Found for Parking");
    }

    public void ExitVehicle(String VehicleType,String VehicleNo){
        for(int CurrFloorNo : FloorTracker.keySet()){
            Floor currFloor = FloorTracker.get(CurrFloorNo);
            for(ParkingSpot parkingSpot : currFloor.getAvailabilitySet(VehicleType)){
                if(!parkingSpot.getAvailableToPark() && parkingSpot.getParkedVehicleNo().equals(VehicleNo)){
                    parkingSpot.removeParking();
                    System.out.println("Vehicle exited from floor no "+currFloor.FloorNo+" in at "+VehicleType+" slot No : "+parkingSpot.SpotNumber);
                    return;
                };
            }
        }
        System.out.println(VehicleNo +" is not found");
    }

    public void FindVehiclePosition(String VehicleType,String VehicleNo){
        for(int CurrFloorNo : FloorTracker.keySet()){
            currFloor = FloorTracker.get(CurrFloorNo);
            for(ParkingSpot parkingSpot : currFloor.getAvailabilitySet(VehicleType)){
                if(!parkingSpot.getAvailableToPark() && parkingSpot.getParkedVehicleNo().equals(VehicleNo)){
                    System.out.println("Vehicle is from floor no "+ currFloor.FloorNo +" in at "+VehicleType+" slot No : "+parkingSpot.SpotNumber);
                    return;
                };
            }
        }
        System.out.println(VehicleNo +" is not found");
    }

}
