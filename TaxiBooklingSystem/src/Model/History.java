package Model;

public class History {
    int bookingID;
    int customerID;
    char from;
    char to;
    int pickupTime;
    int dropTime;
    int charges;

    public History(int bookingID,int customerID,char from,char to,int pickupTime,int dropTime,int charges){
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.charges = charges;
    }

    // Points
    public char getFrom() {
        return from;
    }
    public char getTo() {
        return to;
    }
    // Charge
    public int getCharges() {
        return charges;
    }
    // ID's
    public int getCustomerID() {
        return customerID;
    }

    public int getBookingID() {
        return bookingID;
    }

    // Timings
    public int getDropTime() {
        return dropTime;
    }
    public int getPickupTime() {
        return pickupTime;
    }
}
