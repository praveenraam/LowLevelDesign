import Controller.AuthController;
import Model.*;

class Main{
    public static void main(String[] args) {

        Admin admin = new Admin("praveenraam@gmail.com","password123");

        new Customer("www","www@gmail.com","555");
        new Customer("xxx","xxx@gmail.com","666");
        new Customer("yyy","yyy@gmail.com","777");
        new Customer("zzz","zzz@gmail.com","888");

        Location a = new Location(1,'A',0);
        Location c = new Location(3,'C',4);
        Location d = new Location(4,'D',7);
        Location f = new Location(6,'F',9);
        Location b = new Location(2,'B',15);
        Location g = new Location(7,'G',18);
        Location h = new Location(8,'H',20);
        Location r = new Location(5,'R',23);

        Cab c1 = new Cab(d);
        Cab c2 = new Cab(g);
        Cab c3 = new Cab(h);
        Cab c4 = new Cab(a);

        Driver d1 = new Driver("aaa","aaa@gmail.com","111",c1);
        Driver d2 = new Driver("bbb","bbb@gmail.com","222",c2);
        Driver d3 = new Driver("ccc","ccc@gmail.com","333",c3);
        Driver d4 = new Driver("ddd","ddd@gmail.com","444",c4);

        c1.setDriver(d1);
        c2.setDriver(d2);
        c3.setDriver(d3);
        c4.setDriver(d4);

        AuthController.loginOutInp();
    }
}