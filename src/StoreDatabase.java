/**
 * The store database
 * @author Apoorv Singh, Gaurav Aggarwal
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StoreDatabase implements Serializable {

    private HashMap<String, Building> stores;
    private HashMap<String, User> storeAdmins;
    private HashMap<String, String> nameToIdStores, nameToIdAdmins;
    private int numStores;

    /**
     * Constructor
     */
    public StoreDatabase() {
        stores = new HashMap<>();
        storeAdmins = new HashMap<>();
        nameToIdAdmins = new HashMap<>();
        nameToIdStores = new HashMap<>();
        numStores = 0;
    }

    /**
     *
     * @param parameter StoreAdmin
     * @return Returns StoreAdmin if present, null otherwise
     */
    public User searchStoreAdmin(String parameter) {
        if(storeAdmins.containsKey(parameter)) {
            return storeAdmins.get(parameter);
        }
        else {
            return null;
        }
    }

    /**
     *
     * @param parameter Store name
     * @return Returns Store if present, null otherwise
     */
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

    Store addStore(String storeName, Building warehouse, String adminName, String adminLogin, String adminPassword) {
        String storeId = "S-" + numStores;

        Building store = new Store(storeName,storeId , warehouse);
        User storeAdmin = new StoreAdmin(adminName, adminLogin, adminPassword, store);
        ((Store) store).setMyAdmin(storeAdmin);
        ++numStores;

        stores.put(storeId, store);
        nameToIdStores.put(storeName, storeId);

        storeAdmins.put(adminLogin, storeAdmin);
        nameToIdAdmins.put(adminName, adminLogin);

        return (Store)store;
    }

    public ArrayList<Store> storeList() {
        ArrayList <Store> storeList = new ArrayList<>();
        for (String a : this.stores.keySet()) {
            storeList.add((Store)stores.get(a));
        }
        return storeList;
    }

    Store returnStore(String name) {
        return (Store) stores.get(name);
    }

    /**
     * Deletes the store
     * @param storeID storeID
     */
    void deleteStore(String storeID) {
        String storeAdminName = ((Store)stores.get(storeID)).getMyAdmin().getName();
        String adminLogin = nameToIdAdmins.get(storeAdminName);
        String storeName = ((Store)stores.get(storeID)).getName();
        this.storeAdmins.remove(adminLogin);
        this.nameToIdAdmins.remove(storeAdminName);
        this.nameToIdStores.remove(storeName);
        this.stores.remove(storeID);
        --numStores;
    }

    /**
     * @return Returns list of stores
     */
    public ArrayList<Store> returnList() {
        ArrayList<Store> x = new ArrayList<>();
        for (String a : this.stores.keySet())
            x.add((Store) this.stores.get(a));
        return x;
    }

    /**
     * @return Returns number of stores
     */
    public int getNumStores() {
        return this.numStores;
    }

    /**
     * @param s AdminLogin
     * @return Returns true if name is correct, false otherwise
     */
    public boolean isNamePresent(String s) {
        if(nameToIdStores.containsKey(s))
            return true;
        return false;
    }

    /**
     * @param s AdminLogin
     * @return Returns true if login is correct, false otherwise
     */
    public boolean isAdminLoginPresent(String s) {
        if(storeAdmins.containsKey(s))
            return true;
        return false;
    }

    /**
     * Deleted stores linked to warehouse
     * @param w the warehouse
     */
    public void deleteRelatedStores(Warehouse w) {
        for(String a: stores.keySet()) {
            Store s = (Store)stores.get(a);
            if(s.getLinkedWarehouse() == w) {
                 Main.giveDatabase().getWarehouseDatabase().deleteLinkedStore(s);
                 this.deleteStore(s.getID());
            }
        }
    }

    public ArrayList<Object> returnForConfig() {
        ArrayList<Object> a = new ArrayList<>();
        a.add(stores);
        a.add(storeAdmins);
        a.add(nameToIdAdmins);
        a.add(nameToIdAdmins);
        a.add(numStores);
        return a;
    }
}
