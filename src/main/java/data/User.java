package data;

public class User {
    private String id;
    private String username;
    private String passsword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public User(String username, String passsword) {
        this.username = username;
        this.passsword = passsword;
    }
}
