package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepthOfBinnaryTree {
    public static void main(String[] args) {
        List<Integer> tree = new ArrayList<>();
        tree.add(3);
        tree.add(9);
        tree.add(20);
        tree.add(null);
        tree.add(null);
        tree.add(15);
        tree.add(7);
        TreeNode root = TreeNode.createTree(tree);
        int level = 0;
        Queue<TreeNode> dfs = new LinkedList<>();
        dfs.add(root);
        dfs.add(null);
        while(!dfs.isEmpty()){
            TreeNode currentNode = dfs.poll();
            if(currentNode == null){
                level++;
                if(!dfs.isEmpty()){
                    dfs.add(null);
                }
            }else if(currentNode!=null){
                if(currentNode.left!=null){
                    dfs.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    dfs.add(currentNode.right);
                }
            }
        }
        System.out.println(level);

    }
}
