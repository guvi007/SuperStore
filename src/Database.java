/**
 * The main Database
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    private User superuser;
    private WarehouseDatabase warehouseDatabase;
    private StoreDatabase storeDatabase;
    private EndUserDatabase endUserDatabase;

    /**
     * Constructor for initialising the databases and the superuser.
     */
    public Database() {
        superuser = null;
        warehouseDatabase = new WarehouseDatabase();
        storeDatabase = new StoreDatabase();
        endUserDatabase = new EndUserDatabase();
    }

    /**
     * Getter for WarehouseDatabase
     * @return Returns WarehouseDatabase
     */
    public WarehouseDatabase getWarehouseDatabase() {
        return warehouseDatabase;
    }

    /**
     * Getter for StoreDatabase
     * @return Returns StoreDatabase
     */
    public StoreDatabase getStoreDatabase() {
        return storeDatabase;
    }

    public EndUserDatabase getEndUserDatabase() {
        return endUserDatabase;
    }

    /**
     * Setter for Warehouse Database
     * @param warehouseDatabase The Warehouse Database
     */
    public void setWarehouseDatabase(WarehouseDatabase warehouseDatabase) {
        this.warehouseDatabase = warehouseDatabase;
    }

    /**
     * Setter for Store Database
     * @param storeDatabase The Store Database
     */
    public void setStoreDatabase(StoreDatabase storeDatabase) {
        this.storeDatabase = storeDatabase;
    }

    public void setEndUserDatabase(EndUserDatabase endUserDatabase) {
        this.endUserDatabase = endUserDatabase;
    }

    /**
     * Getter method for SuperUser
     * @return Returns the SuperUser
     */
    public User getSuperUser() {
        return this.superuser;
    }

    /**
     * Checks credentials of superUser
     * @param id ID of SuperUser
     * @param password Password of SuperUser
     * @return Returns SuperUser's credentials are correct, null otherwise
     */
    public User checkSuperUser(String id,String password) {
        if(id.equals(((User)this.superuser).getID()) && password.equals(((User)this.superuser).getPassword())) {
            return this.superuser;
        }
        return null;
    }

    /**
     * Sets the superuser
     */
    public void setSuperUser() {
        this.superuser = new SuperUser(this);
    }

    /**
     * Getter for list of warehouses
     * @return Returns list of warehouses
     */
    ArrayList<String> warehouseList() {
        return this.warehouseDatabase.warehouseList();
    }

    /**
     * Getter for list of stores
     * @return Returns list of stores
     */
    ArrayList<Store> storeList() {
        return this.storeDatabase.storeList();
    }
}
