/**
 * The Building interface. Used by Store and Building
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import java.util.ArrayList;

public interface Building {

    /**
     * For adding a new category/subcategory/product
     * @param Category The category/subcategory in which the addition needs to be done
     * @param stuff The category/subcategory/product which needs to be added
     */
    void addStuff(String Category, Object stuff);

    /**
     * For deleting a category/subcategory/product
     * @param parentCategory The category/subcategory in which a subcategory/product
     *                       needs to be deleted
     * @param stuff The category/subcategory/product that needs to be deleted
     */
    void deleteStuff(String parentCategory, Object stuff);

    /**
     * For modifying a product(price/quantity)
     * @param product The product that needs to be modified
     */
    void modifyProduct(Product product);

    /**
     * Returns The required product
     * @param p The required product
     * @return The required product
     */
    Product returnProduct(Product p);

    /**
     * Checks whether the product is in stock
     * @param p The product which needs to be checked
     * @return Returns true if the product is in stock, false otherwise
     */
    boolean stockChecker(Product p);
}
