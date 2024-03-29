/**
 * This class is the Warehouse class
 * @author Apoorv Singh, Gaurav Aggarwal
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouse implements Building, Serializable {

    private int d,h,k;
    private User myAdmin;
    private final String id, name;
    private ArrayList<Store> stores = new ArrayList<Store>();
    private Catalogue catalogue;

    Warehouse(String name, String ID) {
        this.name = name;
        this.id = ID;
        setK(1);
        setH(1);
        setD(1);
        this.catalogue = new Catalogue();
    }

    public void addLinkedStore(Store s) {
        stores.add(s);
    }

    public ArrayList<Store> returnLinkedStore() {
        return this.stores;
    }

    /**
     * Adds a category
     * @param Category The category/subcategory in which the addition needs to be done
     * @param stuff The category/subcategory/product which needs to be added
     */
    @Override
    public void addStuff(String Category, Object stuff) {
        this.catalogue.addStuff(Category, stuff);
    }

    /**
     * delete Category
     * @param parentCategory The category/subcategory in which a subcategory/product
     *                       needs to be deleted
     * @param stuff The category/subcategory/product that needs to be deleted
     */
    @Override
    public void deleteStuff(String parentCategory, Object stuff) {
        this.catalogue.deleteStuff(parentCategory, stuff);
    }

    @Override
    public void modifyProduct(Product product) {

    }

    /**
     *
     * @param p The required product
     * @return
     */
    @Override
    public Product returnProduct(Product p) {
        for (Product a : this.catalogue.getProductList()) {
            if (a.equals(p))
                return a;
        }
        return null;
    }

    @Override
    public boolean stockChecker(Product p) {
        return true;
    }

    User getMyAdmin() {
        return this.myAdmin;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setMyAdmin(User myAdmin) {
        this.myAdmin = myAdmin;
    }

    public boolean valid(String node, Object o) {
        return this.catalogue.contains(node, o);
    }

    /**
     * orders product for the store
     * @param p
     * @param quantity
     */
    public void orderProduct(Product p, int quantity) {
        Product x = null;
        for (Product a : this.catalogue.getProductList()) {
            if (a.equals(p))
                x = a;
        }
        if (x.getQuantity() < quantity) {
            int q = x.getQuantity() + optimalWarehouse(p, quantity-x.getQuantity());
            p.setQuantity(q);
            x.setQuantity((int)Math.sqrt((2.0*this.d*this.k)/(this.h)));
        }
        if (x.getQuantity() == 0)
            x.setQuantity((int)Math.sqrt((2.0*this.d*this.k)/(this.h)));
    }

    /**
     * finds optimal warehouse
     * @param p
     * @param q
     * @return
     */
    int optimalWarehouse(Product p, int q) {
        return ((WarehouseAdmin)(this.myAdmin)).optimalWarehouse(p,q);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.id + " : " + this.getName();
    }

    /**
     * deletes store if present
     * @param s
     */
    public void checkndelete(Store s) {
        if(stores.contains(s)) {
            stores.remove(s);
        }
    }

    /**
     * return the catalogue for given Store.
     * @return
     */
    public HashMap<String, ArrayList<Object>> getCatalogue() {
        return this.catalogue.getProducts();
    }
}
