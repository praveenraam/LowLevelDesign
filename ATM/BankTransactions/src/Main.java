import java.util.ArrayList;

public class Main {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        static public ArrayList<Integer> preOrder(TreeNode root){
            ArrayList<Integer> list = new ArrayList<>();
            dfs(root,list);
            return list;
        }
        static public void dfs(TreeNode root,ArrayList<Integer> list){

            if(root == null) return;

            list.add(root.val);
            dfs(root.left,list);
            dfs(root.right,list);

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        System.out.println(TreeNode.preOrder(root));
    }
}