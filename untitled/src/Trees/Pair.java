package Trees;

public class Pair {
    TreeNode node;
    int horizontalDistance;

    Pair(int hd,TreeNode node){
        this.node = node;
        this.horizontalDistance = hd;
    }

    public int getHorizontalDistance() {
        return horizontalDistance;
    }
    public TreeNode getNode() {
        return node;
    }
    public void setHorizontalDistance(int horizontalDistance) {
        this.horizontalDistance = horizontalDistance;
    }
    public void setNode(TreeNode node) {
        this.node = node;
    }
}
