/**
 * This class is the Warehouse admin class
 * @author Apoorv Singh, Gaurav Aggarwal
 */
import java.io.Serializable;

public class WarehouseAdmin extends User implements Serializable {

    private Building myWarehouse;
    private WarehouseDatabase database;

    public WarehouseAdmin(String name, String id, String password, Building warehouse, WarehouseDatabase w) {
        super(name, id, password);
        this.myWarehouse = warehouse;
        this.database = w;
    }

    public Warehouse returnMyWarehouse() {
        return (Warehouse)this.myWarehouse;
    }

    /**
     * adds Warehouse categories
     * @param node
     * @param o
     */
    void addStuff(String node, Object o) {
        Warehouse s = (Warehouse) this.myWarehouse;
        s.addStuff(node, o);
    }

    /**
     * delete categories
     * @param node
     * @param o
     */
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

    /**
     * updates values for the required product optimally
     * @param p
     * @param quantity
     * @return
     */
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

}
