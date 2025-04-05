package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
     public static List<Integer>stringArrayToList(String[] strArray){
         List<Integer> intList = new ArrayList<>();
        
        for (String s : strArray) {
            if (s.equals("null")) {
                intList.add(null);  // Handle "null" strings
            } else {
                intList.add(Integer.parseInt(s));  // Convert to Integer and add to list
            }
        }
        return intList;
     }
     public static TreeNode createTree(List<Integer> nodeList){
        if(nodeList == null || nodeList.isEmpty()){
            return null;
        }
        TreeNode rootNode = new TreeNode(nodeList.get(0));

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(rootNode);
        int i = 1;

        while(i<nodeList.size()){
            TreeNode currNode = queue.poll();
            if(i<nodeList.size() && nodeList.get(i)!=null){
                currNode.left = new TreeNode(nodeList.get(i));
                queue.add(currNode.left);
            }
            i++;
            if(i <nodeList.size() && nodeList.get(i)!=null){
                currNode.right = new TreeNode(nodeList.get(i));
                queue.add(currNode.right);

            }
            i++;
        }
        return rootNode;
     }
 }
 