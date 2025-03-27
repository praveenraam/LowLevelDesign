package Service;

import Data.Data;
import Model.Admin;
import Model.Customer;
import Model.Driver;

public class AuthService {

    public static String CustomerLogin(String email,String password){
        for(Customer customer : Data.customerArrayList){
            if(customer.getEmail().equals(email)){
                if(customer.getPassword().equals(password)) return "1";
                else return "Not a valid password";
            }
        }
        return "Customer Not Found";
    }
    public static Customer findCustomer(String email){
        for(Customer customer : Data.customerArrayList){
            if(customer.getEmail().equals(email)){
               return customer;
            }
        }
        return null;
    }

    public static String DriverLogin(String email,String password){
        for(Driver driver : Data.driverArrayList){
            if(driver.getEmail().equals(email)){
                if(driver.getPassword().equals(password)) return "1";
                else return "Not a valid password";
            }
        }
        return "Driver Not Found";
    }
    public static Driver findDriver(String email){
        for(Driver driver : Data.driverArrayList){
            if(driver.getEmail().equals(email)) return driver;
        }
        return null;
    }
    public static String CreateCustomer(String name,String email,String password){
        new Customer(name,email,password);
        return "Successfully created an account";
    }

    public static String AdminLogin(String email,String password){
        for(Admin admin : Data.adminArrayList){
            if(admin.getEmail().equals(email)) return "1";
            else return "Not a valid password";
        }
        return "Admin Not Found";
    }
    public static Admin findAdmin(String email){
        for(Admin admin : Data.adminArrayList){
            if(admin.getEmail().equals(email)){
                return admin;
            }
        }
        return null;
    }

}
