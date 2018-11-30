import java.util.HashMap;

public class WarehouseDatabase{

    private HashMap<String, Building> warehouses;
    private HashMap<String, User> warehouseAdmins;
    private HashMap<String, String> nameToIdWarehouse, nameToIdAdmins;
    private int numWarehouse;

    public WarehouseDatabase() {
        warehouses = new HashMap<>();
        warehouseAdmins = new HashMap<>();
        nameToIdAdmins = new HashMap<>();
        nameToIdWarehouse = new HashMap<>();
        numWarehouse = 0;
    }

    public User searchWarehouseAdmin(String parameter) {
        if(warehouseAdmins.containsKey(parameter)) {
            return warehouseAdmins.get(parameter);
        }
        else {
            return null;
        }
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
//    Building searchWarehouse(String parameter) {
//        if(nameToIdStores.containsKey(parameter)) {
//            parameter = nameToIdStores.get(parameter);
//        }
//        if(stores.containsKey(parameter)) {
//            return stores.get(parameter);
//        }
//        else {
//            return null;
//        }
//    }

}
