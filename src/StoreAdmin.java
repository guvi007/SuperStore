public class StoreAdmin extends User {

    Store myStore;

    StoreAdmin(String name, String ID, String password, Store s) {
        super(name, ID, password);
        this.myStore = s;
    }
}
