import Model.User;
import Services.Input;
import Services.ProcessInput;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1,"Praveen","ckpraveenraam@gmail.com", "9361368149");
        User.addToTracker(1,u1);

        User u2 = new User(2,"Kavin","kavin@gmail.com","78787878787");
        User.addToTracker(2,u2);

        User u3 = new User(3,"Naveen","kavin@gmail.com","78787878787");
        User.addToTracker(3,u3);

        User u4 = new User(4,"Gopal","kavin@gmail.com","78787878787");
        User.addToTracker(4,u4);

        while(true){

            ProcessInput newOps = new ProcessInput();
            newOps.ProcessInputArr();


        }

    }
}