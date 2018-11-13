import java.util.ArrayList;
import java.util.List;

public class StoreDatabase {

    private List<Building> stores;

    StoreDatabase() {
        stores = new ArrayList<Building>();
    }

    Store searchStore(String storeID) {
        for (Store store : stores) {
            if (store.getId.equals(storeID))
                return store;
        }
    }

    List <Building> getStoresList() {
        return this.stores;
    }

    void addStore(Store store) {
        this.stores.add(store);
    }
}
