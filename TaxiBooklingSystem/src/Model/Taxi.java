package Model;

public class Taxi {
    public int taxiID;
    private int customerID;
    private char Current_position;
    private char pick_up_position;
    private char destiny_position;
    private int pickUp_time;
    private int drop_time;
    private int earnings;

    Taxi(int taxiID){
        this.taxiID = taxiID;
        this.customerID = 'A';
    }


    // Current Position
    public void setCurrent_position(char current_position) {
        Current_position = current_position;
    }
    public char getCurrent_position() {
        return Current_position;
    }

    // Customer ID
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public int getCustomerID() {
        return customerID;
    }

    // Pickups,drop timings and positions
    public void setPickUp_time(int pickUp_time) {
        this.pickUp_time = pickUp_time;
    }
    public char getPick_up_position() {
        return pick_up_position;
    }
    public void setDrop_time(int drop_time) {
        this.drop_time = drop_time;
    }
    public int getDrop_time() {
        return drop_time;
    }
    public void setPick_up_position(char pick_up_position) {
        this.pick_up_position = pick_up_position;
    }
    public int getPickUp_position() {
        return pickUp_time;
    }
    public void setDestiny_position(char destiny_position) {
        this.destiny_position = destiny_position;
    }
    public char getDestiny_position() {
        return destiny_position;
    }

    // Earnings
    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
    public int getEarnings(){
        return earnings;
    }

}
