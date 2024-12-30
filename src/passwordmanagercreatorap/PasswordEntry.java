package passwordmanagercreatorap;

public class PasswordEntry {
    private String website;
    private String username;
    private String email;
    private String password;

    //call me a constuction worker atp
    public PasswordEntry(String website, String username, String email, String password) {
        this.website = website;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
