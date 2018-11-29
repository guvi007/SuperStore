import java.util.HashMap;
import java.util.List;

public class StoreDatabase {

    private HashMap<String, Building> stores;
    private HashMap<String, User> storeAdmins;
    private HashMap<String, String> nameToIdStores, nameToIdAdmins;
    private int numStores;

    StoreDatabase() {
        stores = new HashMap<>();
        storeAdmins = new HashMap<>();
        nameToIdAdmins = new HashMap<>();
        nameToIdStores = new HashMap<>();
        numStores = 0;
    }

    Store searchStore() {

    }

    List<Building> getStoresList() {

    }

    boolean checkId(String Id) {
        if(storeAdmins.containsKey(Id))
            return false;
        return true;
    }

    void addStore(String storeName, Building Warehouse, String adminName, String adminLogin, String adminPassword) {
        String storeId = "S" + numStores;

        Building store = new Store(storeName,storeId , Warehouse);
        User storeAdmin = new StoreAdmin(adminName, adminLogin, adminPassword, store);
        ((Store) store).setMyAdmin(storeAdmin);
        ++numStores;

        stores.put(storeId, store);
        nameToIdStores.put(storeName, storeId);

        storeAdmins.put(adminLogin, storeAdmin);
        nameToIdAdmins.put(adminName, adminLogin);
    }
}
