package model;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    public static List<Seller> sellerList = new ArrayList<>();
    private Long id;
    private String email;
    private String password;
    private List<Order> ordersList;
    private List<Order> cart;

    public Seller(String email,String password){

        this.email = email;
        this.password = password;
        sellerList.add(this);
        ordersList = new ArrayList<>();

        id = (long)sellerList.size();
    }


    public boolean isValidPassword(String password){
        return this.password.equals(password);
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId(){
        return id;
    }
}
