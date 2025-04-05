package Trees;

import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;


/**
 * LevelOrder
 */
public class LevelOrder {

    public static int getHeightofTree(TreeNode rootTreeNode){
        if(rootTreeNode == null){
            return 0;
        }
        return Math.max(getHeightofTree(rootTreeNode.left),getHeightofTree(rootTreeNode.right)) + 1;
    }
    public static void inorder(TreeNode roottTreeNode){
        if(roottTreeNode == null){
            return ;
        }
        inorder(roottTreeNode.left);
        System.out.println(roottTreeNode.val);
        inorder(roottTreeNode.right);
    }
    public static void printLevelOrderBFS(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode!=null){
                System.out.print(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }else if(currentNode == null && !queue.isEmpty()){
                queue.add(null);
                System.out.println(" ");
            }
        }
    }
    public static void printCurrentLevel(TreeNode treeNode,int level){
        if(level == 0 || treeNode == null){
            return;
        }
        if(level == 1 ){
            System.out.println(treeNode.val);
        }else if(level > 1){
            printCurrentLevel(treeNode.left, level-1);
            printCurrentLevel(treeNode.right, level-1);

        }
    }

    public static void main(String[] args) {
        String[] tree = {"3", "5", "1", "6", "7", "4", "2", "null", "null", "null", "null", "null", "null", "9", "8"};
        TreeNode rootTreeNode = TreeNode.createTree(TreeNode.stringArrayToList(tree));
        int height = getHeightofTree(rootTreeNode);
        for(int i = 1 ;i<=height;i++){
            printCurrentLevel(rootTreeNode, i);
        }
        System.out.println("using bfss");
        printLevelOrderBFS(rootTreeNode);
    }
}
