public class WarehouseAdmin extends User {

    Warehouse myWarehouse;

    WarehouseAdmin(String name, String id, String password, Warehouse warehouse) {
        super(name, id, password);
        this.myWarehouse = warehouse;
    }

    void addProduct(Product product) {
        this.myWarehouse.addProduct(product);
    }

    void deleteProduct(Product product) {
        this.myWarehouse.deleteProduct(Product);
    }

}
