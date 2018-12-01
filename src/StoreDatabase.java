import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoreDatabase{

    private HashMap<String, Building> stores;
    private HashMap<String, User> storeAdmins;
    private HashMap<String, String> nameToIdStores, nameToIdAdmins;
    private int numStores;

    public StoreDatabase() {
        stores = new HashMap<>();
        storeAdmins = new HashMap<>();
        nameToIdAdmins = new HashMap<>();
        nameToIdStores = new HashMap<>();
        numStores = 0;
    }

    public User searchStoreAdmin(String parameter) {
        if(storeAdmins.containsKey(parameter)) {
            return storeAdmins.get(parameter);
        }
        else {
            return null;
        }
    }

    Building searchStore(String parameter) {
        if(nameToIdStores.containsKey(parameter)) {
            parameter = nameToIdStores.get(parameter);
        }
        if(stores.containsKey(parameter)) {
            return stores.get(parameter);
        }
        else {
            return null;
        }
    }

    boolean checkAdminId(String Id) {
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

    public ArrayList<String> storeList() {
        ArrayList <String> storeList = (ArrayList<String>) this.stores.keySet();
        return storeList;
    }

    Store returnStore(String name) {
        return (Store) stores.get(name);
    }

    void deleteStore(String storeID) {
        String storeAdminName = ((Store)stores.get(storeID)).getMyAdmin().getName();
        String adminLogin = nameToIdAdmins.get(storeAdminName);
        String storeName = ((Store)stores.get(storeID)).getName();
        this.storeAdmins.remove(adminLogin);
        this.nameToIdAdmins.remove(storeAdminName);
        this.nameToIdStores.remove(storeName);
        this.stores.remove(storeID);
    }
}
