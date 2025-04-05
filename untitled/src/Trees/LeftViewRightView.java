package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewRightView {
    public static int getHeightofTree(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeightofTree(root.left), getHeightofTree(root.right)) + 1;
    }
    public static void printLeft(TreeNode root,boolean isPrinted){
        System.out.println("LEFT VIEW");
        if (root == null) {
                return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode!=null){
                if(!isPrinted){
                    System.out.print(currentNode.val);
                    isPrinted = true;
                }
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }else if(currentNode == null && !queue.isEmpty()){
                queue.add(null);
                System.out.println("");
                isPrinted = false;
            }
        }

    }
    public static void printRight(TreeNode root,boolean isPrinted){
        System.out.println("riGHT VIEW");
        if (root == null) {
                return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentNode!=null){
                if(!isPrinted){
                    System.out.print(currentNode.val);
                    isPrinted = true;
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                
            }else if(currentNode == null && !queue.isEmpty()){
                queue.add(null);
                System.out.println("");
                isPrinted = false;
            }
        }
    }
    public static void main(String[] args) {
        String[] tree = {"3", "5", "1", "6", "7", "4", "2", "null", "null", "null", "null", "null", "null", "9", "8"};
        TreeNode rootTreeNode = TreeNode.createTree(TreeNode.stringArrayToList(tree));
        int height = getHeightofTree(rootTreeNode);
        printLeft(rootTreeNode, false);
        printRight(rootTreeNode, false);
    }
}
