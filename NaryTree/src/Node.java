import java.util.ArrayList;

public class Node {

    int val;
    boolean isLock;
    boolean isLockable;
    Node parent;
    ArrayList<Node> children;

    Node(int val,Node parent){
        this.val = val;
        isLock = false;
        isLockable = true;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    private boolean isLocked(){
        return this.isLock;
    }
    private boolean getIsLockable(){
        return this.isLockable;
    }

    static boolean lock(Node root){
        if(root == null) return false;
        if(root.isLocked() || !root.getIsLockable()) return false;

        Node parent = root.parent;
        boolean canLock = true;

        while(parent != null){
            if(!parent.isLockable){
                canLock = false;
                break;
            }
            parent = parent.parent;
        }
        if(!canLock) return false;

        root.isLock = true;
        parent = root.parent;
        while(parent != null){
            parent.isLockable = false;
            parent = parent.parent;
        }

        updateChildren(root,false);

        return true;
    }
    static boolean unlock(Node root){
        if(root == null) return false;
        if(!root.isLocked()) return false;

        root.isLock = false;

        Node parent = root.parent;
        while(parent != null){
            parent.isLockable = true;
            parent = parent.parent;
        }

        updateChildren(root,true);

        return true;
    }

    static void updateChildren(Node root,boolean value){
        if(root == null) return;

        root.isLockable = value;

        for(Node child : root.children) {
            updateChildren(child, value);
        }
    }


}
