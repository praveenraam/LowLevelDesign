package model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public static List<Buyer> buyerList = new ArrayList<>();
    private Long id;
    private String email;
    private String password;
    private List<Order> ordersList;
    private List<Products> cartList;

    Buyer(String email,String password){
        this.email = email;
        this.password = password;
        Buyer.buyerList.add(this);
        ordersList =  new ArrayList<>();

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

    public void addCart(Products products){
        this.cartList.add(products);
    }
    public void removeCart(Products products){
        this.cartList.remove(products);
    }
    public void addOrder(Order order){
        Products product = order.getProduct();
        if(product.getQuantity() <= 0){
            System.out.println(product.getName() + "is not available");
            return;
        }
        product.setQuantity(product.getQuantity()-1);
        this.ordersList.add(order);
    }
    public void removeOrder(Order order){
        this.ordersList.remove(order);
    }

    public void makePayment(){
        float total_cost = 0f;

        for(Products products : cartList){
            total_cost += products.getPrice();
        }
        System.out.println(total_cost);
    }
    public void makePayment(Products product){
        System.out.println(product.getPrice());
    }

    public void checkout(){
        for(Products products : cartList){
            Order order = new Order(products,this,products.getSeller());
            ordersList.add(order);
        }
        cartList.clear();
    }

    public List<Order> getOrdersList(){
        return this.ordersList;
    }
    public Long getId(){
        return id;
    }


}
