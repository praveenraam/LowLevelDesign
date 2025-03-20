import Controller.RegisterLoginController;
import Model.Admin;

public class Main {
    public static void main(String[] args) {

        Admin admin = new Admin("ckpraveenraam@gmail.com","password123");
        RegisterLoginController.startLogin();

    }
}