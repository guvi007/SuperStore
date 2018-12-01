import java.util.ArrayList;

public class WarehouseAdmin extends User {

    private Building myWarehouse;
    private WarehouseDatabase database;

    public WarehouseAdmin(String name, String id, String password, Building warehouse, WarehouseDatabase w) {
        super(name, id, password);
        this.myWarehouse = warehouse;
        this.database = w;
    }

    void addStuff(String node, Object o) {
        Warehouse s = (Warehouse) this.myWarehouse;
        s.addStuff(node, o);
    }

    void deleteStuff(String node, Object o) {
        ((Warehouse)this.myWarehouse).deleteStuff(node, o);
    }

    void changeD(int d) {
        if (d > 0)
            ((Warehouse) this.myWarehouse).setD(d);
    }

    void changeK(int k) {
        if (k > 0)
            ((Warehouse) this.myWarehouse).setK(k);
    }

    void changeH(int h) {
        if (h > 0)
            ((Warehouse) this.myWarehouse).setH(h);
    }

    int optimalWarehouse(Product p, int quantity) {
        Product req = null;
        int currMax = 0;
        for (Warehouse a : this.database.returnList()) {
            Product x = a.returnProduct(p);
            if (x != null && x.getQuantity() > currMax) {
                currMax = x.getQuantity();
                req = x;
            }
        }
        if (req != null) {
            req.setQuantity(Math.max(req.getQuantity()-quantity, 0));
        }
        return Math.min(currMax, quantity);
    }

//    public Product optimalWarehouse(String productID, int quantity) {
////        Product X = database.optimalWarehouse(productID, quantity);
////        return X;
//        return new Product(name, id, price);
//    }


}
