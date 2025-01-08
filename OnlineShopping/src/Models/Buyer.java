package Models;

import java.util.HashMap;

import static Models.Product.getProductWithID;

public class Buyer extends User {
    int buyId;
    String address;
    HashMap<Product,Boolean> ProductOrders;
    static int noOfBuyer = 0;

    private static HashMap<Integer,Buyer> BuyerMap = new HashMap<>();

    public Buyer(String name,String email,String password,String address){
        super(name,email,password);
        noOfBuyer++;
        this.buyId = noOfBuyer;
        this.address = address;
        ProductOrders = new HashMap<>();
        BuyerMap.put(buyId,this);
    }

    static public Buyer getUser(int ID){
        return BuyerMap.get(ID);
    }
    public void changeDeliveryStatus(Product DeliveryStatus){
        ProductOrders.put(DeliveryStatus,false);
    }
    public void BuyOrder(int ProductID){
        Product newOrder = getProductWithID(ProductID);
        ProductOrders.put(newOrder,true);
    }
    public boolean CancelOrder(Product cancelOrder){
        if(ProductOrders.containsKey(cancelOrder) && ProductOrders.get(cancelOrder)){
            ProductOrders.remove(cancelOrder);
            return false;
        }
        return true;
    }
    public boolean ChangeAddress(String newAddress){
        address = newAddress;
        if(address.equals(newAddress)){
            return true;
        }
        return false;
    }

    public void ListOfOrders(){
        System.out.println(this.name+" orders");
        for(Product product : ProductOrders.keySet()){
            System.out.println("    Product ID   : "+product.ProductID );
            System.out.println("        Product Name : "+product.name);
            boolean isDeliveried = ProductOrders.get(product);
            if(isDeliveried){
                System.out.println("        Order status : Not deliveried");
            }
            else System.out.println("        Order status : Deliveried");
        }
    }


}
