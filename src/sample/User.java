public abstract class User {

    private final String name, id, password;

    User(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    String getName() {
        return this.name;
    }

    public String getId() {
        return id;
    }

}
