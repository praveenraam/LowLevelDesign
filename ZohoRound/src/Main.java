import Model.Post;
import Model.User;

import static Service.PostServices.*;
import static Service.UserServices.*;

public class Main {
    public static void main(String[] args) {
        User x = createUser(1,"x");
        User y = createUser(2,"y");
        User z = createUser(3,"z");
        User a = createUser(4,"a");
        User b = createUser(5,"b");
        User c = createUser(6,"c");

        Post p1 = createPost(1,"1st post",x);
        Post p2 = createPost(2,"2nd post",x);
        Post p3 = createPost(3,"3rd post",y);
        Post p4 = createPost(4,"4th post",y);
        Post p5 = createPost(5,"5th post",z);
        Post p6 = createPost(6,"6th post",z);
        Post p7 = createPost(7,"7th post",a);
        Post p8 = createPost(8,"8th post",a);
        Post p9 = createPost(9,"9th post",b);
        Post p10 = createPost(10,"10th post",b);
        Post p11 = createPost(11,"11th post",c);
        Post p12 = createPost(12,"12th post",c);

        addLikeToPost(p1);
        addLikeToPost(p2);
        addLikeToPost(p3);
        addLikeToPost(p4);
        addLikeToPost(p5);
        addLikeToPost(p7);
        addLikeToPost(p9);
        addLikeToPost(p10);
        addLikeToPost(p8);
        addLikeToPost(p11);
        addLikeToPost(p11);
        addLikeToPost(p12);

        displayWall();
        displayWall(x.getName());

        makeTwoUserFriend(x,a);
        makeTwoUserFriend(y,a);
        makeTwoUserFriend(y,z);
        makeTwoUserFriend(x,z);
        makeTwoUserFriend(b,c);

        listOfFriends(x);
        friendSuggested(x.getName());
    }
}