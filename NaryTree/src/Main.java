import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Node root = new Node(1,null);
        Node child1 = new Node(2, root);
        Node child2 = new Node(3, root);
        Node grandChild = new Node(4, child1);

        System.out.println("Locking child1: " + Node.lock(child1)); // true
        System.out.println("Locking root: " + Node.lock(root)); // false (child1 is locked)
        System.out.println("Unlocking child1: " + Node.unlock(child1)); // true
        System.out.println("Locking root: " + Node.lock(root)); // true (now it works)
        System.out.println("Locking grandChild: " + Node.lock(grandChild)); // false (root is locked)

    }
}