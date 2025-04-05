package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;





public class TopOrder {

    public static void getTopOrderTree(TreeNode root){
        if(root == null) return;
        
        TreeMap<Integer,TreeNode> map = new TreeMap<>();


        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(0, root);
        
        q.add(pair);
        
        while (!q.isEmpty()) {
            Pair curentNodePair = q.poll();
            TreeNode curTreeNode = curentNodePair.getNode();
            if(!map.containsKey(curentNodePair.getHorizontalDistance())){
                map.put(curentNodePair.horizontalDistance, curentNodePair.node);
            } 
            if(curTreeNode.left!=null){
                q.add(new Pair(curentNodePair.horizontalDistance - 1, curTreeNode.left));
            }
            if(curTreeNode.right!=null){
                q.add(new Pair(curentNodePair.horizontalDistance + 1, curTreeNode.right));
            }
        }
        for(Integer i:map.keySet()){
            System.out.println(map.get(i).val);
        }


    }

    public static void main(String[] args) {
        String[] tree = {"3", "5", "1", "6", "7", "4", "2", "null", "null", "null", "null", "null", "null", "9", "8"};
        TreeNode root = TreeNode.createTree(TreeNode.stringArrayToList(tree));
        getTopOrderTree(root);
    }    
}

