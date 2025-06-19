package Model;

import Data.Data;

public class Driver extends User{
    private String name;
    private Cab cab;

    public Driver(String name,String email, String password,Cab cab) {
        super(Data.driverCount++,email, password);
        this.cab = cab;
        this.name = name;
        Data.driverArrayList.add(this);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
