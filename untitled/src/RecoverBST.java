import java.util.ArrayList;
import java.util.List;

import Trees.TreeNode;

public class RecoverBST {
    public  static void inOrder(TreeNode root,List<TreeNode>list){
        if(root == null) 
            return ;
        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);
    }
    public static void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root,list);
        for(TreeNode n:list){
            System.out.println(n.val);
        }
    }
    
    public static void main(String[] args) {

        String[] tree = {"1","3","null","null","2"};
        TreeNode root = TreeNode.createTree(TreeNode.stringArrayToList(tree));
        recoverTree(root);
        
    }
}
