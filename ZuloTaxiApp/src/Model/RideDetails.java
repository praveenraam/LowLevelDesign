package Model;

public class RideDetails {

    Location source;
    Location destination;
    Driver driver;
    Cab cab;
    Customer customer;
    int totalFair;
    int driverFair;
    int zuloFair;

    public RideDetails(Location source, Location destination, Driver driver,Customer customer, Cab cab, int totalFair) {
        this.source = source;
        this.destination = destination;
        this.driver = driver;
        this.customer = customer;
        this.cab = cab;
        this.totalFair = totalFair;
        this.driverFair =  (int) ((30.0 / 100) * totalFair);
        this.zuloFair = totalFair-driverFair;
    }
}
