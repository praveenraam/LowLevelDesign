package Models;

import java.util.HashMap;

public class Orders {
    int OrderID;
    Product OrderedProduct;
    int BuyerID;

    static HashMap<Integer,Orders> AllOrders = new HashMap<>();

}
