import Model.Post;
import Model.User;

import static Service.PostServices.*;
import static Service.UserServices.*;

public class Main2 {
    public static void main(String[] args) {
        User x = createUser(1,"x");
        User y = createUser(2,"y");
        User z = createUser(3,"z");
        User a = createUser(4,"a");
        User b = createUser(5,"b");
        User c = createUser(5,"c");

        makeTwoUserFriend(x,a);
        makeTwoUserFriend(x,c);
        makeTwoUserFriend(a,b);
        makeTwoUserFriend(a,y);
        makeTwoUserFriend(c,y);

        findCommonMan(x,y);
    }
}
