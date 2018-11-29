public class SuperUser extends User {

    private boolean firstTime = true;
    private Database database;

    private final String ID = "SU0";

    SuperUser(String name, String password, String myID, Database d) {
        super("Apoorv","SU0", "SU0");
        this.firstTime = false;
        this.database = d;
    }

    void createStore(String name, Warehouse w, String adminName, String adminLogin, String adminpassword) {
        if (database.checkID(adminLogin))
            database.addStore(name, w, adminName, adminLogin, adminpassword);
        else
            throw new CommonIDException("The ID is already there");
    }

    public boolean isFirstTime() {
        return firstTime;
    }
}
