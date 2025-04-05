package Trees;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GetGoodNode {
    public static int getGoodNodeCount(TreeNode root){
        int count = 0;
        int maxSoFar = root.val;
        int lastMax = maxSoFar;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.val >= maxSoFar ){
                lastMax = maxSoFar;
                maxSoFar = cur.val;
                count++;
                System.out.println("Node Val-->" + cur.val);
            }
            if(cur.left==null && cur.right==null){
               maxSoFar = lastMax;
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
             if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        return count;
    }
    public static int goodNodes(TreeNode root) {
        return getGoodNodeCount(root);
    }
    public static void main(String[] args) {
        String[] tree = {
            "-1", "5", "-2", "4", "4", "2", "-2", "null", "null", "-4", 
            "null", "-2", "3", "null", "-2", "0", "null", "-1", "null", 
            "-3", "null", "-4", "-3", "3", "null", "null", "null", 
            "null", "null", "null", "null", "3", "-3"
        };
        TreeNode rootTreeNode = TreeNode.createTree(TreeNode.stringArrayToList(tree));
        System.out.println(goodNodes(rootTreeNode));
    }
}
