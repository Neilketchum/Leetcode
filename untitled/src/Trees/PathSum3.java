package Trees;

public class PathSum3 {
    public static int pathSumNode(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        int res = 0;
        if(targetSum == root.val){
            res++;
        }
        res+= pathSumNode(root.left,targetSum - root.val);
        res += pathSumNode(root.right,targetSum - root.val);   
        return res;
    }
    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        return pathSum(root.left,targetSum) + pathSumNode(root,targetSum) + pathSum(root.right,targetSum) ;   
    }
    public static void main(String[] args) {
        String[] tree = {"1000000000", "1000000000", "null", "294967296", "null", "1000000000", "null", "1000000000", "null", "1000000000"};        ;

        TreeNode rootTreeNode = TreeNode.createTree(TreeNode.stringArrayToList(tree));
        System.out.println(pathSum(rootTreeNode,0));
    }
}
