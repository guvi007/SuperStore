public class WarehouseAdmin extends User {

    Building myWarehouse;
    WarehouseDatabase database;

    public WarehouseAdmin(String name, String id, String password, Building warehouse, WarehouseDatabase w) {
        super(name, id, password);
        this.myWarehouse = warehouse;
        this.database = w;
    }

    public void addProduct(Product product) {
//        this.myWarehouse.addProduct(product);
    }

    public void deleteProduct(Product product) {
//        this.myWarehouse.deleteProduct(Product);
    }

    public Product optimalWarehouse(String productID, int quantity) {
//        Product X = database.optimalWarehouse(productID, quantity);
//        return X;
        return new Product();
    }

    public void modifyProduct(String productID, int quantity, int price) {
        return;
    }

}
