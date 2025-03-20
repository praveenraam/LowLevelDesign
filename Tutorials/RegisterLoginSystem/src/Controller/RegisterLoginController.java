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
                String out2 = "Enter Email : ";
                System.out.println(out2);
                String inpEmail = in.nextLine();

                String out3 = "Enter password : ";
                System.out.println(out3);
                String inpPassword = in.nextLine();

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
            else if(inp1 == 2) {

                String out2 = "Enter Name : ";
                System.out.println(out2);
                String inpName = in.nextLine();

                String out3 = "Enter Email : ";
                System.out.println(out3);
                String inpEmail = in.nextLine();

                String out4 = "Enter password : ";
                System.out.println(out4);
                String inpPassword = in.nextLine();

                User user = RegisterLoginService.createUser(inpEmail, inpPassword, inpName);
                System.out.println(user);
            }
            else{
                System.out.println("Enter proper Number\n");
            }

        }

    }


}
