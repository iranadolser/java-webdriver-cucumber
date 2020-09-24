package pages;

public class UserLogin {

    private String name;
    private String login;
    private String password;

    public UserLogin(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password.charAt(0) + "*********";
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
