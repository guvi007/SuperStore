public class StoreAdmin extends User {

    Building myStore;

    StoreAdmin(String name, String ID, String password, Building s) {
        super(name, ID, password);
        this.myStore = s;
    }
}
