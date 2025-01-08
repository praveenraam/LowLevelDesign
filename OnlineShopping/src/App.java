import Models.Buyer;
import Models.Product;
import Models.Seller;
public class App {

    public static void main(String[] args) {
        Buyer B1 = new Buyer("Praveen","praveen@gmail.com","@praveen","1/51A");
        Buyer B2 = new Buyer("Mithun","mithun@gmail.com","@mithun","1/65C");

        Seller S1 = new Seller("ABC LTD","owner@abcltd.com","@abcltd","SkinCare","2/31A");
        Seller S2 = new Seller("DEF LTD","owner@defltd.com","@defltd","Electronics","2/940");

        S1.addProduct(new Product("Facewash","SkinCare",220,20,S1));
        S1.addProduct(new Product("Shampoo","SkinCare",480,80,S1));

        S2.addProduct(new Product("Laptop","Electronics",65000,5,S2));
        S2.addProduct(new Product("Mobile","Electronics",22000,5,S2));

        Product.listProduct();

        B1.BuyOrder(3);
        B1.changeDeliveryStatus(Product.getProductWithID(3));
        B2.BuyOrder(4);
        B2.BuyOrder(1);
        B2.BuyOrder(2);

        B2.changeDeliveryStatus(Product.getProductWithID(4));

        B1.ListOfOrders();
        B2.ListOfOrders();
        B1.ChangeAddress("1/51B");
        B2.CancelOrder(Product.getProductWithID(1));

        Buyer B1Copy = Buyer.getUser(1);
        System.out.println(S2.getSellerProductsList());

        System.out.println(Product.getProductWithID(1).getPrice());
        Product.getProductWithID(1).setDiscount(0);
        System.out.println(Product.getProductWithID(1).getPrice());
    }
}
