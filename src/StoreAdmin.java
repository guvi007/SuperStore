public class StoreAdmin extends User {

    Building myStore;

    StoreAdmin(String name, String ID, String password, Building s) {
        super(name, ID, password);
        this.myStore = s;
    }

    void addStuff(String node, Object o) {
        Store s = (Store) this.myStore;
        if (((Warehouse)s.getLinkedWarehouse()).valid(node, o)) {
            s.addStuff(node, o);
        }
    }

    void deleteStuff(String node, Object o) {
        ((Store)this.myStore).deleteStuff(node, o);
    }

    void changeD(int d) {
        if (d > 0)
            ((Store) this.myStore).setD(d);
    }

    void changeK(int k) {
        if (k > 0)
            ((Store) this.myStore).setK(k);
    }

    void changeH(int h) {
        if (h > 0)
            ((Store) this.myStore).setH(h);
    }
}
