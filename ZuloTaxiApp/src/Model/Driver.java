package Model;

import Data.Data;

public class Driver extends User{
    private String name;

    public Driver(String name,String email, String password) {
        super(Data.driverCount++,email, password);
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
