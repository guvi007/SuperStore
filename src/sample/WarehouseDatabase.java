import java.util.ArrayList;
import java.util.List;

public class WarehouseDatabase {

    private List<Building> warehouses;

    WarehouseDatabase() {
        this.warehouses = new ArrayList<Building>();
    }

    void addWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
    }

    List<Building> getWarehouseList() {
        return this.warehouses;
    }

    Warehouse optimalWarehouse(Warehouse w, Product p) {
        for (Building warehouse : this.warehouses) {
            warehouse = (Warehouse) warehouse;
            return (Warehouse) warehouse;
        }
    }

}
