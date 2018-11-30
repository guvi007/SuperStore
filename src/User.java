public abstract class User {

    private final String Name, ID, password;

    public User() {
        Name = "";
        ID = "";
        password = "";
    }

    public User(String name, String ID, String password) {
        this.ID = ID;
        this.password = password;
        this.Name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.Name;
    }
}
