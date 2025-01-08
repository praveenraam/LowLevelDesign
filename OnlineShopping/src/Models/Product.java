package Models;

import com.sun.source.tree.Tree;
import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.TreeMap;

public class Product implements Comparable<Product>{
    int ProductID;
    String name;
    Seller seller;
    String category;
    private double price;
    private double discount;
    static int totalNoOfProduct = 0;
    static TreeMap<Integer, Product> ProductList = new TreeMap<>();

    public Product(String name,String category,double price,double discount,Seller seller){
        totalNoOfProduct++;
        this.ProductID = totalNoOfProduct;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.seller = seller;
        ProductList.put(ProductID,this);
    }
    static public Product getProductWithID(int ID){
        return ProductList.get(ID);
    }
    public void remove(){
        Seller seller = ProductList.get(this.ProductID).seller;
        seller.removeProduct(this);
        ProductList.remove(ProductID);
    }
    public double getPrice(){
        if(discount == 0) return price;
        return price - (price*(discount/100));
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    public void setDiscount(double newDiscount){
        this.discount = newDiscount;
    }
    public double getDiscount() {
        return discount;
    }
    public static void listProduct(){
        for(int ID : ProductList.keySet()){
            Product product = ProductList.get(ID);
            System.out.println("ID : "+ID);
            System.out.println("     Name   : "+ product.name);
            System.out.println("     Seller : "+ product.seller.name);
            System.out.println("     Price  : "+ product.getPrice());
        }
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.ProductID, other.ProductID);
    }
}
