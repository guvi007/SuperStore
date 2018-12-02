/**
 * Controller for checking credentials of users
 * @author Apoorv Singh, Gaurav Aggarwal
 */

public class login {
    private Database db;
    private static login log;

    /**
     * Sets up the database
     * @param d the database
     */
    private login(Database d) {
        this.db = d;
    }

    /**
     *
     * @param d The database
     * @return Returns login object
     */
    public static login getInstance(Database d) {
        if(log == null) {
            log = new login(d);
        }
        return log;
    }

    /**
     * Checks the credentials of the warehouse admin
     * @param id id of the user
     * @param password password of the user
     * @return Returns the user if the credentials are correct, null otherwise
     */
    public User checkWarehouseAdmin(String id, String password) {
        WarehouseDatabase db = this.db.getWarehouseDatabase();
        User temp = db.searchWarehouseAdmin(id);
        return checkPassword(temp,id,password);
    }

    /**
     * Checks the credentials of the store admin
     * @param id id of the user
     * @param password password of the user
     * @return Returns the user if the credentials are correct, null otherwise
     */
    public User checkStoreAdmin(String id, String password) {
        StoreDatabase db = this.db.getStoreDatabase();
        User temp = db.searchStoreAdmin(id);
        return checkPassword(temp,id,password);
    }

    /**
     * Checks the credentials of the superuser
     * @param id id of the user
     * @param password password of the user
     * @return Returns the user if the credentials are correct, null otherwise
     */
    public User checkSuperUser(String id, String password) {
        User temp = db.checkSuperUser(id, password);
        return temp;
    }

    /**
     * Checks the password
     * @param temp The temporary instance of the user
     * @param id id of the user
     * @param password password of the user
     * @return Returns the user if the credentials are correct, null otherwise
     */
    private User checkPassword(User temp, String id, String password) {
        if(temp == null) {
            return null;
        }
        else {
            if(!(password.equals(temp.getPassword())))
                return null;
            else
                return temp;
        }
    }
}
