package Services;

import Model.Admin;
import Model.User;
import Model.UserAbsClass;

public class RegisterLoginService {

    public static UserAbsClass verifyLogin(String email, String password){

        for(User user : User.getUserList()){
            if(user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    return user;
                }
                else{
                    return null;
                }
            }
        }

        for(Admin admin : Admin.getAdminList()){
            if(admin.getEmail().equals(email)){
                if(admin.getPassword().equals(password)){
                    return admin;
                }
                else{
                    return null;
                }
            }
        }

        return null;
    }

    public static User createUser(String inpEmail, String inpPassword, String inpName) {
        return new User(inpName,inpEmail,inpPassword);
    }
}
