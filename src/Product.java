/**
 * The Product Class
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {

    private String name, ID;
    private int price, quantity;

    /**
     * Initialises the product
     * @param name name of the product
     * @param id id of the product
     * @param price price of the product
     * @param quantity quantity of the product
     *
     */
    Product(String name, String id, int price, int quantity) {
        this.name = name;
        ID = id;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Setter for name
     * @param name name of product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for id
     * @param id id of product
     */
    public void setID(String id) {
        this.ID = id;
    }

    /**
     * Getter method for name
     * @return Returns name of product
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for id
     * @return Returns id of product
     */
    public String getID() {
        return ID;
    }

    /**
     * Getter method for quantity
     * @return Returns quantity of product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity
     * @param quantity quantity of product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter method for price
     * @return Returns price of product
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for price
     * @param price price of product
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns whether products are equal or not
     * @param o The product being compared to
     * @return Returns true if products are equal, false otherwise
     */
    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.getName());
    }

    /**
     *
     * @return Return toString form
     */
    @Override
    public String toString() {
        return this.getName() + " : " + this.getID();
    }
}
