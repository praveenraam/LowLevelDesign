package Services;

import Model.User;

public class RegisterService {

    public static User registerUserService(String name, String password, String address, String phoneNo, float income_per_year){
        User user = new User(name,password,address,phoneNo,income_per_year);
        return user;
    }

}
