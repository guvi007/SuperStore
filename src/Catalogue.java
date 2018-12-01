import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalogue implements Serializable {

    private HashMap<String, ArrayList<Object>> products;
    private ArrayList<Product> productList;

    Catalogue() {
        this.products = new HashMap<String, ArrayList<Object>>();
        this.productList = new ArrayList<Product>();
        this.products.put("root", new ArrayList<Object>());
    }

    void addStuff(String Category, Object o) {
        this.products.get(Category).add(o);
        if (o instanceof Product)
            this.productList.add((Product)o);
        else
            this.products.put((String)o, new ArrayList<Object>());
    }

    void deleteStuff(String parentCategory, Object o) {
        if (!(o instanceof Product)) {
            for (Object a : this.products.get((String)o)) {
                if (!(a instanceof Product))
                    this.products.remove((String) a);
            }
        }
        this.products.get(parentCategory).remove(o);
    }

    HashMap<String, ArrayList<Object>> getProducts() {
        return this.products;
    }

    boolean contains(String node, Object o) {
        if (this.products.get(node).contains(o))
            return true;
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
