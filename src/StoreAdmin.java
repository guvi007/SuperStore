/**
 * Class for Store Admin
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import java.io.Serializable;

public class StoreAdmin extends User implements Serializable {

    private Building myStore;

    /**
     * Constructor for store Admin
     * @param name store admin name
     * @param ID store admin ID
     * @param password store admin password
     * @param s Store
     */
    StoreAdmin(String name, String ID, String password, Building s) {
        super(name, ID, password);
        this.myStore = s;
    }

    /**
     * For adding category/subcategory/product
     * @param node Parent category/subcategory
     * @param o Obect to be added
     */
    void addStuff(String node, Object o) {
        Store s = (Store) this.myStore;
        if (((Warehouse)s.getLinkedWarehouse()).valid(node, o)) {
            s.addStuff(node, o);
        }
    }

    /**
     * For Deleting category/subcategory/product
     * @param node Parent category/subcategory
     * @param o Obect to be added
     */
    void deleteStuff(String node, Object o) {
        ((Store)this.myStore).deleteStuff(node, o);
    }

    /**
     * Changes D
     * @param d D
     */
    void changeD(int d) {
        if (d > 0)
            ((Store) this.myStore).setD(d);
    }

    /**
     * Changes K
     * @param k K
     */
    void changeK(int k) {
        if (k > 0)
            ((Store) this.myStore).setK(k);
    }

    /**
     * Changes H
     * @param h H
     */
    void changeH(int h) {
        if (h > 0)
            ((Store) this.myStore).setH(h);
    }

    /**
     * @return Returns your store
     */
    public Store myStore() {
        return (Store)this.myStore;
    }
}
