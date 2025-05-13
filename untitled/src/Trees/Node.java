package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
     public int data;
     public Node left;
     public Node right;
     Node() {}
     Node(int val) { this.data = val; }
     Node(int val, Node left, Node right) {
         this.data = val;
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
     public static Node createTree(List<Integer> nodeList){
        if(nodeList == null || nodeList.isEmpty()){
            return null;
        }
        Node rootNode = new Node(nodeList.get(0));

        Queue<Node> queue = new LinkedList<>();

        queue.add(rootNode);
        int i = 1;

        while(i<nodeList.size()){
            Node currNode = queue.poll();
            if(i<nodeList.size() && nodeList.get(i)!=null){
                currNode.left = new Node(nodeList.get(i));
                queue.add(currNode.left);
            }
            i++;
            if(i <nodeList.size() && nodeList.get(i)!=null){
                currNode.right = new Node(nodeList.get(i));
                queue.add(currNode.right);

            }
            i++;
        }
        return rootNode;
     }
 }
 