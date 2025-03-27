package Controller;

import Model.Driver;
import Model.User;
import Service.AuthService;
import Service.TaxiBookingService;

import java.util.Scanner;

public class AuthController {

    private static Scanner in = new Scanner(System.in);

    public static void loginOutInp(){

        while(true){

            String op1 = "Enter 1 to login\nEnter 2 to register\nEnter 3 to admin Login\nEnter 4 to driver Login\nEnter 5 to Exit";
            System.out.println(op1);
            int inp1 = in.nextInt();
            in.nextLine();

            if(inp1 == 1){
                handleLogin();
            }
            else if(inp1 == 2){
                handleRegistration();
            }
            else if(inp1 == 3){
                handleAdminLogin();
            }
            else if(inp1 == 4){
                handleDriverLogin();
            }
            else if(inp1 == 5) break;
            else System.out.println("Enter a valid no");

            System.out.println();
        }
    }

    public static void handleLogin(){
        Pair pair = getForLogin();

        String serviceOutput = AuthService.CustomerLogin(pair.email,pair.password);
        if(serviceOutput.equals("1")){
            User user = AuthService.findCustomer(pair.email);

            TaxiBookingController taxiBookingController = new TaxiBookingController();
            taxiBookingController.startBookingTaxi();

        }
        else System.out.println(serviceOutput);
    }
    public static void handleAdminLogin(){

        Pair pair = getForLogin();

        String serviceOutput = AuthService.AdminLogin(pair.email,pair.password);
        if(serviceOutput.equals("1")){
            User user = AuthService.findAdmin(pair.email);
            System.out.println("Adm Logged");
            //
        }
        else System.out.println(serviceOutput);
    }
    public static void handleDriverLogin(){
        Pair pair = getForLogin();
        String serviceOutput = AuthService.DriverLogin(pair.email,pair.password);

        if(serviceOutput.equals("1")){
            Driver driver = AuthService.findDriver(pair.email);
            System.out.println("Driver Logged");
        }
        else System.out.println(serviceOutput);
    }

    public static void handleRegistration(){
        String op2 = "Enter name : ";
        String inpName = getInp(op2);

        Pair pair = getForLogin();

        String serviceOutput = AuthService.CreateCustomer(inpName,pair.email,pair.password);
        System.out.println(serviceOutput);
    }

    public static Pair getForLogin(){
        String op2 = "Enter email : ";
        String inpEmail = getInp(op2);

        String op3 = "Enter password : ";
        String inpPassword = getInp(op3);

        return new Pair(inpEmail,inpPassword);
    }

    public static String getInp(String message){
        System.out.println(message);
        return in.nextLine();
    }

}
class Pair{
    String email;
    String password;
    public Pair(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
