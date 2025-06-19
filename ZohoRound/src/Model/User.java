package Model;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<User> allUsersInZacebook = new ArrayList<>();
    private Long id;
    private String name;

    private List<Post> postListByUser = new ArrayList<>();
    private List<Post> topPostByUser = new ArrayList<>();
    private List<User> userFriendList = new ArrayList<>();

    public User(Long id, String name) {
        this.id = id;
        this.name = name;

        allUsersInZacebook.add(this);
    }

    public List<User> getUserFriendList() {
        return userFriendList;
    }

    public void setUserFriendList(List<User> userFriendList) {
        this.userFriendList = userFriendList;
    }

    public List<Post> getTopPostByUser() {
        return topPostByUser;
    }

    public void setTopPostByUser(List<Post> topPostByUser) {
        this.topPostByUser = topPostByUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPostListByUser() {
        return postListByUser;
    }

    public void setPostListByUser(List<Post> postListByUser) {
        this.postListByUser = postListByUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
