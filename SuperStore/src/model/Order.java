package model;


import java.util.ArrayList;
import java.util.List;

public class Order {

    public static List<Order> ordersList = new ArrayList<>();
    private Long id;
    private Products product;
    private Buyer buyer;
    private Seller seller;

    public Order(Products product, Buyer buyer, Seller seller){
        this.product = product;
        this.buyer = buyer;
        this.seller = seller;

        ordersList.add(this);
        id = (long) ordersList.size();
    }

    public Long getId() {
        return id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
