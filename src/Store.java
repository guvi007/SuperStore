/**
 * The store class
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Store implements Building, Serializable {

    private int d,h,k;
    private final String name, ID;
    private Building linkedWarehouse;
    private User myAdmin;
    private Catalogue catalogue;

    /**
     * Constructor for the store class
     * @param name The store name
     * @param ID The store ID
     * @param w The linked warehouse
     */
    Store(String name, String ID, Building w) {
        this.name = name;
        this.ID = ID;
        setK(1);
        setH(1);
        setD(1);
        setLinkedWarehouse(w);
        this.catalogue = new Catalogue();
    }


    @Override
    public void addStuff(String Category, Object stuff) {
        this.catalogue.addStuff(Category, stuff);
    }

    @Override
    public void deleteStuff(String parentCategory, Object stuff) {
        this.catalogue.deleteStuff(parentCategory, stuff);
    }


    @Override
    public void modifyProduct(Product product) {

    }

    @Override
    public Product returnProduct(Product p) {
        return p;
    }

    @Override
    public boolean stockChecker(Product p) {
        return true;
    }

    /**
     * @return Getter for K
     */
    public int getK() {
        return k;
    }

    /**
     * Setter for K
     * @param k K
     */
    public void setK(int k) {
        this.k = k;
    }

    /**
     * @return Getter for H
     */
    public int getH() {
        return h;
    }

    /**
     * Setter for H
     * @param h H
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * @return Getter for D
     */
    public int getD() {
        return d;
    }

    /**
     * Setter for D
     * @param d D
     */
    public void setD(int d) {
        this.d = d;
    }

    /**
     * Getter for linked Warehouse
     * @return Returns linked Warehouse
     */
    public Building getLinkedWarehouse() {
        return linkedWarehouse;
    }

    /**
     * setter for linked warehouse
     * @param linkedWarehouse linked warehouse
     */
    public void setLinkedWarehouse(Building linkedWarehouse) {
        this.linkedWarehouse = linkedWarehouse;
    }

    /**
     * Setter for store admin
     * @param myAdmin store admin
     */
    public void setMyAdmin(User myAdmin) {
        this.myAdmin = myAdmin;
    }

    /**
     * Getter for store admin
     * @return Returns store admin
     */
    public User getMyAdmin() {
        return myAdmin;
    }

    /**
     * @param name Query given
     * @return Returns search results
     */
    ArrayList<Product> returnProductList(String name) {
        ArrayList<Product> ProductList = new ArrayList<Product>();
        for (Product a : this.catalogue.getProductList()) {
            if (a.getName().toLowerCase().contains(name.toLowerCase()))
                ProductList.add(a);
        }
        return ProductList;
    }

    /**
     * To order product from warehouse
     * @param p The product
     */
    void orderProduct(Product p) {
        int quantity = (int)Math.sqrt((2.0*this.d*this.k)/(this.h));
        ((Warehouse)this.linkedWarehouse).orderProduct(p,quantity);
    }

    /**
     * For sale of the product
     * @param p The product
     * @param quantity Product's Quantity
     */
    void sellProduct(Product p, int quantity) {
        p.setQuantity(p.getQuantity()-quantity);
        if (p.getQuantity() == 0)
            orderProduct(p);
    }

    /**
     * @return Getter for store name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Getter for store id
     */
    public String getID() {
        return ID;
    }

    /**
     * @return toString method of store
     */
    @Override
    public String toString() {
        return this.ID + " : " + this.getName();
    }

    /**
     * @return Returns the inventory of items
     */
    public HashMap<String, ArrayList<Object>> getCatalogue() {
        return this.catalogue.getProducts();
    }
}
