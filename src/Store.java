import java.util.ArrayList;
import java.util.HashMap;

public class Store implements Building {

    private int d,h,k;
    private final String name, ID;
    private Building linkedWarehouse;
    private User myAdmin;
    private Catalogue catalogue;

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

    public Building getLinkedWarehouse() {
        return linkedWarehouse;
    }

    public void setLinkedWarehouse(Building linkedWarehouse) {
        this.linkedWarehouse = linkedWarehouse;
    }

    public void setMyAdmin(User myAdmin) {
        this.myAdmin = myAdmin;
    }

    public User getMyAdmin() {
        return myAdmin;
    }

    ArrayList<Product> returnProductList(String name) {
        ArrayList<Product> ProductList = new ArrayList<Product>();
        for (Product a : this.catalogue.getProductList()) {
            if (a.getName().toLowerCase().contains(name.toLowerCase()))
                ProductList.add(a);
        }
        return ProductList;
    }

    void orderProduct(Product p) {
        int quantity = (int)Math.sqrt((2.0*this.d*this.k)/(this.h));
        ((Warehouse)this.linkedWarehouse).orderProduct(p,quantity);
    }

    void sellProduct(Product p, int quantity) {
        p.setQuantity(p.getQuantity()-quantity);
        if (p.getQuantity() == 0)
            orderProduct(p);
    }

}
