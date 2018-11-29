import java.util.ArrayList;
import java.util.List;

public class EndUserDatabase extends Database{

    private List<User> endUsers;

    EndUserDatabase() {
        endUsers = new ArrayList<User>();
    }

    List<User> getEndUsers() {
        return this.endUsers;
    }

    void addEndUser(User endUser) {
        this.endUsers.add(endUser);
    }

}
