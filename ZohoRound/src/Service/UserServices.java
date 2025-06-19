package Service;
import Model.Post;
import Model.User;
import static Model.User.*;

import java.util.ArrayList;
import java.util.List;

public class UserServices {

    public static User createUser(int id,String name){
        return new User((long)id,name);
    }

    public static List<Post> getPostByUsername(String name){
        User user = null;
        for(int iter=0;iter<allUsersInZacebook.size();iter++){
            if(allUsersInZacebook.get(iter).getName().equals(name)){
                user = allUsersInZacebook.get(iter);
                break;
            }
        }
        if(user == null) return null;

        return user.getPostListByUser();
    }

    public static void makeTwoUserFriend(User user1,User user2){
        user1.getUserFriendList().add(user2);
        user2.getUserFriendList().add(user1);
        System.out.println("\n"+user1.getName()+" and "+user2.getName()+" are friends");
    }

    private static List<User> usersMutualFriend(User user1,User user2){

        List<User> returningList = new ArrayList<>();

        List<User> user2List = user2.getUserFriendList();
        List<User> user1List = user1.getUserFriendList();
        for(int iter=0;iter<user2List.size();iter++){
            if(user1.getId() == user2List.get(iter).getId()) continue;
            if(user1List.contains(user2List.get(iter))) returningList.add(user2List.get(iter));
        }

        return returningList;
    }
    public static void findMutuals(User u1,User u2){
        List<User> listOfMutuals = usersMutualFriend(u1,u2);

        if(listOfMutuals.isEmpty()){
            System.out.println("\nNo mutuals");
            return;
        }

        System.out.println("\nMutual of "+u1.getName()+" in"+u2.getName()+"'s list are");
        for(User u : listOfMutuals){
            System.out.println(u);
        }

    }

    public static void listOfFriends(User user){
        List<User> friends = user.getUserFriendList();

        if(friends.isEmpty()) {
            System.out.println("\nNo friends for "+user.getName());
            return;
        }

        System.out.println("\nFriends of "+user.getName());
        for(User u : friends){
            System.out.println(u);
        }
    }

    public static void friendSuggested(String name){
        User user = null;
        for(int iter=0;iter<allUsersInZacebook.size();iter++){
            if(allUsersInZacebook.get(iter).getName().equals(name)){
                user = allUsersInZacebook.get(iter);
                break;
            }
        }
        if(user == null) return;

        List<User> notInUsersFriend = new ArrayList<>();
        
        for(int iter=0;iter<allUsersInZacebook.size();iter++){
            if(!user.getUserFriendList().contains(allUsersInZacebook.get(iter)))
            {
                notInUsersFriend.add(allUsersInZacebook.get(iter));
            }
        }
        
        int count = 0;
        User suggestingFriend = null;
        for(int iter=0;iter<notInUsersFriend.size();iter++){
            if(user.getId() == notInUsersFriend.get(iter).getId()) continue;
            int result = usersMutualFriend(user,notInUsersFriend.get(iter)).size();
            if(count < result){
                count = result;
                suggestingFriend = notInUsersFriend.get(iter);
            }
        
        }
        
        if(suggestingFriend == null) {
            System.out.println("\nNo suggestion");
        } else System.out.println("\nFriend suggested is "+suggestingFriend.getName());
    }

    public static void findCommonMan(User u1,User u2){

        for(int iter=0;iter<allUsersInZacebook.size();iter++){
            long id = allUsersInZacebook.get(iter).getId();
            if(id == u1.getId() || id == u2.getId()) continue;

            if(allUsersInZacebook.get(iter).getUserFriendList().contains(u1)
                &&
               allUsersInZacebook.get(iter).getUserFriendList().contains(u2)
            ){
                System.out.println("\nCommon one : "+allUsersInZacebook.get(iter).getName());
                return;
            }
        }

        System.out.println("No user found for making connection");
    }

}
