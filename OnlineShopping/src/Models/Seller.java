package Models;

import java.util.HashMap;

public class Seller extends User{
    int sellerID;
    String category;
    String AddressOfCompany;
    private int noOfProduct = 0;

    HashMap<Integer,Product> SellerProductsMap;
    static int noOfSellers = 0;

    public Seller(String name,String email,String password,String category,String AddressOfCompany){
        super(name,email,password);
        noOfSellers++;
        this.sellerID = noOfSellers;
        this.category = category;
        this.AddressOfCompany = AddressOfCompany;
        SellerProductsMap = new HashMap<>();

    }
    public void addProduct(Product newValue){
        SellerProductsMap.put(newValue.ProductID,newValue);
        noOfProduct++;
    }
    public void removeProduct(Product removingValue){
        SellerProductsMap.remove(removingValue.ProductID);
        removingValue.remove();
        noOfProduct--;
    }
    public HashMap<Integer,Product> getSellerProductsList(){
        return SellerProductsMap;
    }
}
