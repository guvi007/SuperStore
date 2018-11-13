package sample;

public class Database {
    private WarehouseDatabase warehouseDatabase = new WarehouseDatabase();
    private StoreDatabase storeDatabase = new StoreDatabase();
    private EndUserDatabase endUserDatabase = new EndUserDatabase();

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
}
