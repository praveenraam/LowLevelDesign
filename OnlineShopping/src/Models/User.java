package Models;

public class User {
    String name;
    String email;
    private String password;

    public User(String name,String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String newValue){
        password = newValue;
    }
}
