
public class login {
    private Database db;
    private static login log;

    private login(Database d) {
        this.db = d;
    }

    public static login getInstance(Database d) {
        if(log == null) {
            log = new login(d);
        }
        return log;
    }

    public User checkWarehouseAdmin(String id, String password) {
        WarehouseDatabase db = this.db.getWarehouseDatabase();
        User temp = db.searchWarehouseAdmin(id);
        return checkPassword(temp,id,password);
    }

    public User checkStoreAdmin(String id, String password) {
        StoreDatabase db = this.db.getStoreDatabase();
        User temp = db.searchStoreAdmin(id);
        return checkPassword(temp,id,password);
    }

    public User checkSuperUser(String id, String password) {
        User temp = db.checkSuperUser(id, password);
        return temp;
    }

    private User checkPassword(User temp, String id, String password) {
        if(temp == null) {
            return null;
        }
        else {
            if(password != temp.getPassword())
                return null;
            else
                return temp;
        }
    }
}
