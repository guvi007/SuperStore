import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseDatabase implements Serializable {

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

    public void addWarehouse(String WarehouseName, String adminName, String adminLogin, String adminPassword) {
        String WarehouseId = "W-" + numWarehouse;

        Building warehouse = new Warehouse(WarehouseName,WarehouseId);
        User warehouseAdmin = new WarehouseAdmin(adminName, adminLogin, adminPassword, warehouse, this);
        ((Warehouse) warehouse).setMyAdmin(warehouseAdmin);
        ++numWarehouse;

        warehouses.put(WarehouseId, warehouse);
        nameToIdWarehouse.put(WarehouseName, WarehouseId);

        warehouseAdmins.put(adminLogin, warehouseAdmin);
        nameToIdAdmins.put(adminName, adminLogin);
    }

    public ArrayList<String> warehouseList() {
        ArrayList <String> warehouseList = (ArrayList<String>) this.warehouses.keySet();
        return warehouseList;
    }

    Warehouse returnWarehouse(String warehouseID) {
        return (Warehouse) warehouses.get(warehouseID);
    }

    public void deleteWarehouse(String warehouseID) {
        String warehouseAdminName = ((Warehouse)warehouses.get(warehouseID)).getMyAdmin().getName();
        String adminLogin = nameToIdAdmins.get(warehouseAdminName);
        String warehouseName = ((Warehouse)warehouses.get(warehouseID)).getName();
        this.warehouseAdmins.remove(adminLogin);
        this.nameToIdAdmins.remove(warehouseAdminName);
        this.nameToIdWarehouse.remove(warehouseName);
        this.warehouses.remove(warehouseID);
        --numWarehouse;
    }

    public ArrayList<Warehouse> returnList() {
        ArrayList<Warehouse> x = new ArrayList<>();
        for (String a : this.warehouses.keySet())
            x.add((Warehouse) this.warehouses.get(a));
        return x;
    }

    public int getNumWarehouse() {
        return this.numWarehouse;
    }

    public boolean isNamePresent(String s) {
        if(nameToIdWarehouse.containsKey(s))
            return true;
        return false;
    }

    public boolean isAdminLoginPresent(String s) {
        if(warehouseAdmins.containsKey(s))
            return true;
        return false;
    }

    public void deleteLinkedStore(Store s) {
        for(String a : this.warehouses.keySet()) {
            Warehouse w = (Warehouse)this.warehouses.get(a);
            w.checkndelete(s);
        }
    }

    public ArrayList<Object> returnForConfig() {
        ArrayList<Object> a = new ArrayList<>();
        a.add(warehouses);
        a.add(warehouseAdmins);
        a.add(nameToIdWarehouse);
        a.add(nameToIdAdmins);
        a.add(numWarehouse);
        return a;
    }
}
