package Model;

import Model.ENUM.Role;

import java.util.ArrayList;

public class User extends UserAbsClass{

    private static ArrayList<User> userList = new ArrayList<>();
    private String name;
    public User(String name, String email, String password) {
        super(userList.size()+1, email, password, Role.USER);

        this.name = name;
        userList.add(this);
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static void setUserList(ArrayList<User> userList) {
        User.userList = userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{ " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
