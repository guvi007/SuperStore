/**
 * This class is abstract for users
 * @author Apoorv Singh, Gaurav Aggarwal
 */
import java.io.Serializable;

public abstract class User implements Serializable {

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
