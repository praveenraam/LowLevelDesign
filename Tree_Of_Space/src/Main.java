
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inputGather = new Scanner(System.in);

        int numberOfNodes = inputGather.nextInt();
        int childrenPerNode = inputGather.nextInt();
        int queryCount = inputGather.nextInt();

        inputGather.nextLine();

        String[] nodes = new String[numberOfNodes];
        for (int iter = 0; iter < numberOfNodes; iter++) {
            nodes[iter] = inputGather.nextLine();
        }

//        inputGather.nextLine();

        String[] queries = new String[queryCount];
        for(int iter=0;iter<queryCount;iter++){
            queries[iter] = inputGather.nextLine();
        }

        HashMap<String,TreeNode> map = new HashMap<>();

        TreeNode root = new TreeNode(nodes[0],null);
        map.put(nodes[0],root);

        int index = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() != 0 && index < numberOfNodes){

            TreeNode parent = q.poll();
            for (int iter=0;iter<childrenPerNode && index<numberOfNodes;iter++){
                TreeNode child = new TreeNode(nodes[index],parent);
                parent.childrens.add(child);

                map.put(nodes[index],child);
                q.add(child);
                index++;
            }
        }

        for(String query : queries){

            String[] splittedArr = query.split("\\s+");

            int number = Integer.parseInt(splittedArr[0]);
            String valueOf = splittedArr[1];
            int userId = Integer.parseInt(splittedArr[2]);

            if(!map.containsKey(valueOf)){
                System.out.println(map.containsKey(valueOf)+" "+valueOf);
                System.out.println("False");
                return;
            }

            TreeNode node = map.get(valueOf);
            boolean result = false;
            switch (number){
                case 1: // Lock
                    result = TreeNode.LockNode(node, userId);
                    break;
                case 2: // Unlock
                    result = TreeNode.unLock(node, userId);
                    break;
                case 3: // Upgrade
                    result = TreeNode.upgrade(node, userId);
                    break;
            }
            System.out.println(result);
        }

    }
}