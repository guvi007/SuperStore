import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalogue {

    HashMap<String, ArrayList<Object>> products;

    Catalogue() {
        this.products = new HashMap<String, ArrayList<Object>>();
    }

    void addStuff(String Category, Object o) {
        this.products.get(Category).add(o);
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
}
