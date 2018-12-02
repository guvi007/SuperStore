/**
 * The Catalogue class contains the inventory
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalogue implements Serializable {

    private HashMap<String, ArrayList<Object>> products;
    private ArrayList<Product> productList;

    /**
     * The constructor initialises the list of product and the inventory
     */
    Catalogue() {
        this.products = new HashMap<String, ArrayList<Object>>();
        this.productList = new ArrayList<Product>();
        this.products.put("root", new ArrayList<Object>());
    }

    /**
     * Function for adding a new category/subcategory/product to the inventory.
     * @param Category The category/subcategory in which the subcategory/product needs
     *                 to be added
     * @param o The category/subcategory/product that needs to be added
     */
    void addStuff(String Category, Object o) {
        this.products.get(Category).add(o);
        if (o instanceof Product)
            this.productList.add((Product)o);
        else
            this.products.put((String)o, new ArrayList<Object>());
    }

    /**
     * Deletes the category/subcategory/product from the inventory
     * @param parentCategory The parent category/subcategory
     * @param o The category/subcategory/product that needs to be deleted
     */
    void deleteStuff(String parentCategory, Object o) {
        if (!(o instanceof Product)) {
            for (Object a : this.products.get((String)o)) {
                if (!(a instanceof Product))
                    this.products.remove((String) a);
            }
        }
        this.products.get(parentCategory).remove(o);
    }

    /**
     * Returns the inventory of products
     * @return Returns the inventory of products
     */
    public HashMap<String, ArrayList<Object>> getProducts() {
        return this.products;
    }

    /**
     * Tells whether the category/subcategory/product is in the category/subcategory.
     * @param node The parent category/subcategory
     * @param o The category/subcategory/product that needs to be checked
     * @return Returns true if the object is present, false otherwise
     */
    boolean contains(String node, Object o) {
        if (this.products.get(node).contains(o))
            return true;
        return false;
    }

    /**
     * Returns the list of products
     * @return Returns the list of products
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
}
