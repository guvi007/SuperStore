import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Building {
    private static int idForAll;
    private final String id;
    private final String name;
    private List<Store> stores = new ArrayList<Store>();

    public Warehouse() {
        id = null;
        name = null;
    }

    public Warehouse(String name) {
        this.id = "0";
        this.name = name;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public void modifyProduct(Product product) {

    }

    @Override
    public Product returnProduct() {

    }

    @Override
    public boolean stockChecker(Product p) {

    }
}
