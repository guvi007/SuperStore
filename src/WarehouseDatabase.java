import java.util.HashMap;

public class WarehouseDatabase extends Database{

    private HashMap<String, Building> warehouses;
    private HashMap<String, User> warehouseAdmins;
    private HashMap<String, String> nameToIdWarehouse, nameToIdAdmins;
    private int numWarehouse;

    WarehouseDatabase() {
        warehouses = new HashMap<>();
        warehouseAdmins = new HashMap<>();
        nameToIdAdmins = new HashMap<>();
        nameToIdWarehouse = new HashMap<>();
        numWarehouse = 0;
    }

//    void addWarehouse(Warehouse warehouse) {
//
//    }
//
//    List<Building> getWarehouseList() {
//
//    }
//
//    Warehouse optimalWarehouse(String productID, int quantity) {
//        for (Building warehouse : this.warehouses) {
//            warehouse = (Warehouse) warehouse;
//            return (Warehouse) warehouse;
//        }
//    }
//
//    Warehouse searchWarehouse(String ID) {
//        for (Building warehouse : this.warehouses)
//        {
//            if (warehouse.getId.equals(ID)) {
//                return warehouse;
//            }
//        }
//    }

}
