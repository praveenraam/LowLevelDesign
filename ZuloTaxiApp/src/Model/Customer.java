package Model;

import Data.Data;

import java.util.ArrayList;

public class Customer extends User{
    private String name;

    public Customer(String name,String email, String password) {
        super(Data.customerCount++,email, password);
        this.name = name;
        Data.customerArrayList.add(this);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
