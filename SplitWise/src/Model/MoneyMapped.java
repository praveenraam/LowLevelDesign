package Model;

public class MoneyMapped {
    User user;
    float money;

    public MoneyMapped(User User, float money){
        this.user = User;
        this.money = money;
    }
    MoneyMapped(User User){
        this.user = User;
    }

}
