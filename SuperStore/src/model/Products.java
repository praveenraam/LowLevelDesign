package model;

import java.util.ArrayList;
import java.util.List;

public class Products {
    static List<Products> productsList = new ArrayList<>();
    Long id;
    Seller seller;
    String name;
    Float price;
    String description;
    Long quantity;

    public Products(String name,String description,Seller seller,Float price,Long quantity){
        this.name = name;
        this.description = description;
        this.seller = seller;
        this.price = price;
        this.quantity = quantity;

        productsList.add(this);
        id = (long)productsList.size();
    }

    public Long getId() {
        return id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void listInventory(){
        int no = 1;
        for(Products product : productsList){
            System.out.println(no + ". : "+product.getName());
        }
    }

}
