package Models;

public class ParkingSpot {
    int SpotNumber;
    private boolean isAvailable = true;
    private String ParkedVehicleNo;

    public ParkingSpot(int Spot){
        this.SpotNumber = Spot;
    }

    public boolean getAvailableToPark() {
        return isAvailable;
    }
    public void addToParking(String ParkedVehicleNo){
        this.ParkedVehicleNo = ParkedVehicleNo;
        isAvailable = false;
    }
    public void removeParking(){
        this.ParkedVehicleNo = "";
        isAvailable = true;
    }

    public String getParkedVehicleNo(){
        return ParkedVehicleNo;
    }
}
