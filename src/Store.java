
public class Store implements Building {

    private int d,h,k;
    private final String name, ID;
    private Building linkedWarehouse;
    private User myAdmin;
    private Catalogue catalogue;

    Store(String name, String ID, Building w) {
        this.name = name;
        this.ID = ID;
        setK(0);
        setH(1);
        setD(0);
        setLinkedWarehouse(w);
        this.catalogue = new Catalogue();
    }


    @Override
    public void addProduct(Product product) {
        this.catalogue.addProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        this.catalogue.deleteProduct(product);
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
}
