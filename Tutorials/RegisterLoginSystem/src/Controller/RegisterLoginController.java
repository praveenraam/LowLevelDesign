package Controller;

import Model.ENUM.Role;
import Model.User;
import Model.UserAbsClass;
import Services.RegisterLoginService;

import java.util.Scanner;

public class RegisterLoginController {

    private static Scanner in = new Scanner(System.in);

    public static void startLogin(){
        while(true){

            String out1 = "1 to login \n2 to register\n     : ";
            System.out.print(out1);

            int inp1 = in.nextInt();
            in.nextLine();

            if(inp1 == 1){
                handleLogin();
            }
            else if(inp1 == 2) {
                handleRegistration();
            }
            else{
                System.out.println("Enter proper Number\n");
            }
        }
    }

    public static void handleRegistration(){

        String inpName = getStringInput("Enter the Name : ");
        String inpEmail = getStringInput("Enter the Email : ");
        String inpPassword = getStringInput("Enter the Password : ");

        User user = RegisterLoginService.createUser(inpEmail, inpPassword, inpName);
        System.out.println(user);
    }
    public static void handleLogin(){

        String inpEmail = getStringInput("Enter the Email : ");
        String inpPassword = getStringInput("Enter the Password : ");

        UserAbsClass userOrAdmin = RegisterLoginService.verifyLogin(inpEmail,inpPassword);
        if(userOrAdmin != null){
            System.out.println("You logged in");
            if(userOrAdmin.getRole().equals(Role.ADMIN)){
                // Call Function related to admin
            }
            else{
                // Call the main function
            }
        }
        else{
            System.out.println("Enter proper credentials");
        }
    }

    public static String getStringInput(String outputMessage){
        System.out.print(outputMessage);
        return in.nextLine();
    }

}
