public class WarehouseAdmin extends User {

    Warehouse myWarehouse;
    WarehouseDatabase database;

    WarehouseAdmin(String name, String id, String password, Warehouse warehouse, WarehouseDatabase w) {
        super(name, id, password);
        this.myWarehouse = warehouse;
        this.database = w;
    }

    void addProduct(Product product) {
        this.myWarehouse.addProduct(product);
    }

    void deleteProduct(Product product) {
        this.myWarehouse.deleteProduct(Product);
    }

    Product optimalWarehouse(String productID, int quantity) {
        Product X = database.optimalWarehouse(productID, quantity);
        return X;
    }

    void modifyProduct(String productID, int quantity, int price) {
        return;
    }

}
