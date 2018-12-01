import java.util.ArrayList;

public class Database {
    private User superuser;
    private WarehouseDatabase warehouseDatabase;
    private StoreDatabase storeDatabase;
    private EndUserDatabase endUserDatabase;

    public Database() {
        superuser = null;
        warehouseDatabase = new WarehouseDatabase();
        storeDatabase = new StoreDatabase();
        endUserDatabase = new EndUserDatabase();
    }

    public WarehouseDatabase getWarehouseDatabase() {
        return warehouseDatabase;
    }

    public StoreDatabase getStoreDatabase() {
        return storeDatabase;
    }

    public EndUserDatabase getEndUserDatabase() {
        return endUserDatabase;
    }

    public void setWarehouseDatabase(WarehouseDatabase warehouseDatabase) {
        this.warehouseDatabase = warehouseDatabase;
    }

    public void setStoreDatabase(StoreDatabase storeDatabase) {
        this.storeDatabase = storeDatabase;
    }

    public void setEndUserDatabase(EndUserDatabase endUserDatabase) {
        this.endUserDatabase = endUserDatabase;
    }

    public User getSuperUser() {
        return this.superuser;
    }

    public User checkSuperUser(String id,String password) {
        if(id.equals(((User)this.superuser).getID()) && password.equals(((User)this.superuser).getPassword())) {
            return this.superuser;
        }
        return null;
    }

    public void setSuperUser() {
        this.superuser = new SuperUser(this);
    }

    ArrayList<String> warehouseList() {
        return this.warehouseDatabase.warehouseList();
    }

    ArrayList<String> storeList() {
        return this.storeDatabase.storeList();
    }
}
