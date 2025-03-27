package Model;

import Data.Data;

public class Admin extends User{
    public Admin(String email, String password) {
        super(Data.adminCount, email, password);
        Data.adminArrayList.add(this);
    }
}
