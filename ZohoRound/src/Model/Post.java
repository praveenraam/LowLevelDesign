package Model;

import java.util.ArrayList;
import java.util.List;

public class Post {

    public static List<Post> allPostsInZacebook = new ArrayList<>();
    public static List<Post> overAllTopPostByCount = new ArrayList<>();
    public static List<Post> overAllTopPostByLike = new ArrayList<>();
    private Long id;
    private String text;
    private User postedUser;
    private int likeCount;

    public Post(Long id, String text, User postedUser) {
        this.id = id;
        this.text = text;
        this.postedUser = postedUser;
        this.likeCount = 0;

        allPostsInZacebook.add(this);
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getPostedUser() {
        return postedUser;
    }

    public void setPostedUser(User postedUser) {
        this.postedUser = postedUser;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", likeCount=" + likeCount +
                '}';
    }
}
