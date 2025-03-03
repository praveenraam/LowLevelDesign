package model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public static List<Buyer> buyerList = new ArrayList<>();
    private Long id;
    private String email;
    private String password;
    private List<Products> productList;

    Buyer(String email,String password){
        this.email = email;
        this.password = password;
        Buyer.buyerList.add(this);
        productList =  new ArrayList<>();

        id = (long) (Buyer.buyerList.size());
    }

    public boolean isValidPassword(String password){
        return this.password.equals(password);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public void addItem(Products product){
        this.productList.add(product);
    }
    public Products removeItem(Products product){
        this.productList.remove(product);
        return product;
    }
    public List<Products> getProductList(){
        return this.productList;
    }
    public Long getId(){
        return id;
    }
}
