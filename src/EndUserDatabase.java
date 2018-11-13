import java.util.ArrayList;
import java.util.List;

public class EndUserDatabase {

    private List<User> endUsers;

    EndUserDatabase() {
        endUsers = new ArrayList<User>();
    }

    List<User> getEndUsers() {
        return this.endUsers;
    }

    void addEndUser(EndUser endUser) {
        this.endUsers.add(endUser);
    }

}
