package Service;

import Model.Post;
import Model.User;
import Model.Post.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static Model.Post.*;
import static Service.UserServices.*;
public class PostServices {

    public static Post createPost(int id, String content, User userCreated){
        Post newPost =  new Post((long)id,content,userCreated);

        removePostByCount(newPost);
        userCreated.getPostListByUser().add(newPost);

        return newPost;
    }

    private static void removePostByCount(Post newPost){
        if(overAllTopPostByCount.size() >= 10){
            overAllTopPostByCount.remove(0);
        }
        overAllTopPostByCount.add(newPost);
    }

//    private static void removePostByLike(Post newPost){
//
//        if(overAllTopPostByLike.size() < 10){
//            overAllTopPostByLike.add(newPost);
//        }
//    }

//    private static void removePostByLikeAfterLike(Post likedPost){
//
//        if(!(overAllTopPostByCount.contains(likedPost))){
//            int minIdx = 0;
//
//            for(int iter=0;iter<overAllTopPostByLike.size();iter++){
//
//                if(overAllTopPostByLike.get(minIdx).getLikeCount() > overAllTopPostByLike.get(iter).getLikeCount()){
//                    minIdx = iter;
//                }
////                System.out.println(overAllTopPostByLike.get(minIdx).getId() +" "+ overAllTopPostByLike.get(iter).getLikeCount());
//
//            }
//
//            if(overAllTopPostByLike.get(minIdx).getLikeCount() < likedPost.getLikeCount()){
//                System.out.println(overAllTopPostByLike.get(minIdx).getLikeCount() +" "+ likedPost.getLikeCount());
//
//                overAllTopPostByCount.remove(overAllTopPostByCount.get(minIdx));
//                overAllTopPostByCount.add(likedPost);
//            };
//        }
//
//    }

    public static void displayWall(){
        System.out.println("Top recent posts");
        for(int iter=overAllTopPostByCount.size()-1;iter>=0;iter--){
            System.out.println(overAllTopPostByCount.get(iter));
        }

        getTopLikedPost();
        System.out.println("\nTop liked posts");
        for(int iter=0;iter<overAllTopPostByLike.size();iter++) {
            System.out.println(overAllTopPostByLike.get(iter));
        }
    }

    public static void displayWall(String username){
        List<Post> postedPosts = getPostByUsername(username);
        System.out.println("\nUser "+username+"'s wall");

        for(Post p : postedPosts){
            System.out.println(p);
        }

        for(int iter=0;iter<allPostsInZacebook.size();iter++){

            if(allPostsInZacebook.get(iter).getText().contains(username)){
                System.out.println(allPostsInZacebook.get(iter));
            }

        }

    }

    private static void getTopLikedPost(){
        overAllTopPostByLike = new ArrayList<>();

        PriorityQueue<Post> hp = new PriorityQueue<>((a,b)-> Integer.compare(b.getLikeCount(),a.getLikeCount()));

        for(int iter=0;iter<allPostsInZacebook.size();iter++){
            hp.offer(allPostsInZacebook.get(iter));
        }

        for(Post p : hp.stream().toList()){
            overAllTopPostByLike.add(p);
            if(overAllTopPostByLike.size() == 10) return;
        }

    }

    public static void addLikeToPost(Post post){
        post.setLikeCount(post.getLikeCount()+1);
//        removePostByLikeAfterLike(post);
    }
    public static void removeLikeToPost(Post post) {
        post.setLikeCount(post.getLikeCount()-1);
    }

}
