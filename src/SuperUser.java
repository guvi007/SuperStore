import java.io.Serializable;

public class SuperUser extends User implements Serializable {

    private StoreDatabase storeDatabase;
    private WarehouseDatabase wareHouseDatabase;
    private EndUserDatabase endUserDatabase;

    private final String ID = "SU0";

    public SuperUser() {}

    public SuperUser(Database d) {
        super("Apoorv","SU0", "SU0");
        this.storeDatabase = d.getStoreDatabase();
        this.wareHouseDatabase = d.getWarehouseDatabase();
        this.endUserDatabase = d.getEndUserDatabase();
    }

}
