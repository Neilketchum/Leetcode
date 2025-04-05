package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SameLeaf {
    public static void main(String[] args) {
        String[] tree1 =  {"1","2","200"};//{"3", "5", "1", "6", "2", "9", "8", "null", "null", "7", "4"};
        String[] tree2 = {"1","2","200"};//{"3", "5", "1", "6", "7", "4", "2", "null", "null", "null", "null", "null", "null", "9", "8"};
        TreeNode rootNode1 = TreeNode.createTree(TreeNode.stringArrayToList(tree1));
        TreeNode rootNode2 = TreeNode.createTree(TreeNode.stringArrayToList(tree2));
        List<Integer> leafNodes1 = new ArrayList<>();
        List<Integer> leafNodes2 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        stack.add(rootNode1);
    
        while(!stack.isEmpty()){
            TreeNode curentNode = stack.pop();
            if(curentNode.left == null && curentNode.right == null){
                leafNodes1.add(curentNode.val);
            }else{
                if(curentNode.right!=null){
                    stack.add(curentNode.right);
                }
                if(curentNode.left!=null){
                    stack.add(curentNode.left);
                }
               
            }
        }
        stack = new Stack<>();

        stack.add(rootNode2);

        while(!stack.isEmpty()){
            TreeNode curentNode = stack.pop();
            if(curentNode.left == null && curentNode.right == null){
                leafNodes2.add(curentNode.val);
            }else{
                if(curentNode.right!=null){
                    stack.add(curentNode.right);
                }
                if(curentNode.left!=null){
                    stack.add(curentNode.left);
                }
                
                
            }
        }
        if(leafNodes1.size() == leafNodes2.size()){
            for(int i = 0;i<leafNodes1.size();i++){
                if(leafNodes1.get(i) != leafNodes2.get(i)){
                    System.out.println(leafNodes1.get(i));
                    System.out.println(leafNodes2.get(i));
                    System.out.println("false");
                }
            }
            System.out.println("True");
        }else{
            System.out.println("false");
        }
    }



}
