import java.util.ArrayList;

public class TreeNode {

    String name;
    int userID;
    boolean isLocked;
    TreeNode parent;
    ArrayList<TreeNode> childrens;
    int anc_locked;
    int des_locked;

    TreeNode(String name,TreeNode parent){
        this.name = name;
        this.parent = parent;
        this.childrens = new ArrayList<>();
        this.userID = -1;
        this.anc_locked = 0;
        this.des_locked = 0;
    }

    static boolean LockNode(TreeNode nodeToLock,int userID){

        if(nodeToLock.isLocked) return false;
        if(nodeToLock.anc_locked > 0 || nodeToLock.des_locked > 0) return false;

        TreeNode parent = nodeToLock.parent;

        while(parent != null){
            parent.des_locked++;
            parent = parent.parent;
        }

        updateChildren(nodeToLock,1);

        nodeToLock.isLocked = true;
        nodeToLock.userID = userID;

        return true;
    }
    static boolean unLock(TreeNode nodeToUnlock,int userID){

        if(!nodeToUnlock.isLocked || nodeToUnlock.userID != userID) return false;

        TreeNode parent = nodeToUnlock.parent;
        while (parent != null){
            parent.des_locked--;
            parent = parent.parent;
        }
        updateChildren(nodeToUnlock,-1);

        nodeToUnlock.isLocked = false;
        nodeToUnlock.userID = -1;

        return true;
    }

    static void updateChildren(TreeNode nodeChildrenToUpdate, int val){
        if(nodeChildrenToUpdate == null) return;
        nodeChildrenToUpdate.anc_locked+=val;

        for(TreeNode child : nodeChildrenToUpdate.childrens){
            updateChildren(child,val);
        }
    }

    static boolean upgrade(TreeNode nodeToUpgrade,int userID){

        if(nodeToUpgrade.isLocked || nodeToUpgrade.des_locked == 0 || nodeToUpgrade.anc_locked >0){
            return false;
        }

        ArrayList<TreeNode> listOfChildren = new ArrayList<>();
        boolean isLockedBySameID = isChildLocked(nodeToUpgrade,userID,listOfChildren);

        if(!isLockedBySameID) return false;

        for(TreeNode child : listOfChildren){
            unLock(child,userID);
        }

        nodeToUpgrade.isLocked = true;
        nodeToUpgrade.userID = userID;

        return true;

    }
    static boolean isChildLocked(TreeNode nodeToCheck,int userID,ArrayList<TreeNode> listOfChild){

        if(nodeToCheck == null) return true;

        if(nodeToCheck.isLocked){
            if(nodeToCheck.userID != userID) return false;
            listOfChild.add(nodeToCheck);
        }

        if(nodeToCheck.des_locked == 0) return true;

        for(TreeNode child : nodeToCheck.childrens) {
            boolean isValidToUpgrade = isChildLocked(child,userID,listOfChild);
            if(!isValidToUpgrade) return false;
        }

        return true;
    }

}
