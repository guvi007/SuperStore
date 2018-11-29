public abstract class User {

    private final String Name, ID, password;

    User(String name, String ID, String password) {
        this.ID = ID;
        this.password = password;
        this.Name = name;
    }
}
