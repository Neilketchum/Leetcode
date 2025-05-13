package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TopView {
    public static class NodeWithHDD{
        Node node;
        int hdd;
        NodeWithHDD(Node node, int hdd){
            this.node = node;
            this.hdd = hdd;
        }
    }
    static ArrayList<Integer> zigZagTraversal(Node root)  {

        if(root == null) return new ArrayList<>();

        Queue<NodeWithHDD> queue = new LinkedList<>();

        HashMap<Integer,Node> bview = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();

        Set<Integer> hdd = new HashSet<>();
    }




    static ArrayList<Integer> topView(Node root) {
        // code here
        if(root == null) return new ArrayList<>();
        Queue<NodeWithHDD> queue = new LinkedList<>();
        ArrayList<NodeWithHDD>topView = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        Set<Integer> hdd = new HashSet<>();
        queue.add(new NodeWithHDD(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i<size;i++){
                NodeWithHDD cur = queue.poll();
                if(!hdd.contains(cur.hdd)){
                    hdd.add(cur.hdd);
                    topView.add(cur);
                }
                if(cur.node.left!=null){
                    queue.add(new NodeWithHDD(cur.node.left, cur.hdd-1));                    
                }
                if(cur.node.right != null){
                    queue.add(new NodeWithHDD(cur.node.right, cur.hdd+1));
                }
            }
        }
        // Sort topView based on hdd
        topView.sort((a, b) -> Integer.compare(a.hdd, b.hdd));
        // Add node.data to result
        for (NodeWithHDD nwh : topView) {
            result.add(nwh.node.data);
        }
        return result;
        
    }
    public static void main(String[] args) {
       
    }
}
