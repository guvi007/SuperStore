import java.util.ArrayList;
import java.util.List;

public class EndUserDatabase{

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
