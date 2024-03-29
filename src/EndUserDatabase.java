import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EndUserDatabase implements Serializable {

    private List<User> endUsers;

    public EndUserDatabase() {
        endUsers = new ArrayList<>();
    }

    public List<User> getEndUsers() {
        return this.endUsers;
    }

    public void addEndUser(User endUser) {
        this.endUsers.add(endUser);
    }

}
