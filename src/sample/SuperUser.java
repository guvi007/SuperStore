public class SuperUser extends User {

    SuperUser(String name, String id, String password) {
        super(name, id, password);
    }

    WarehouseAdmin createWarehouseAdmin(Warehouse warehouse) {
        String id = "w";
    }
}
