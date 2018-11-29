public class SuperUser extends User {

    private boolean firstTime = true;
    private StoreDatabase storeDatabase;
    private WarehouseDatabase wareHouseDatabase;
    private EndUserDatabase endUserDatabase;

    private final String ID = "SU0";

    SuperUser(String name, String password, String myID, Database d) {
        super("Apoorv","SU0", "SU0");
        this.firstTime = false;
        this.storeDatabase = d.getStoreDatabase();
        this.wareHouseDatabase = d.getWarehouseDatabase();
        this.endUserDatabase = d.getEndUserDatabase();
    }

    void createStore(String name, Warehouse w, String adminName, String adminLogin, String adminpassword) {
        if (storeDatabase.checkAdminId(adminLogin))
            storeDatabase.addStore(name, w, adminName, adminLogin, adminpassword);
        else
            throw new CommonIDException("The ID is already there");
    }

    public boolean isFirstTime() {
        return firstTime;
    }
}
