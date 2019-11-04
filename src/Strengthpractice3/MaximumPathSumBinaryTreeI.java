package Strengthpractice3;

public class MaximumPathSumBinaryTreeI {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        // 人形path use recursion
        // 1.what will we expect from child subtree?
        //    the max sum from current child(including) node to leaf(cannot be the same one)
        // 2.what will do on current node?
        //    update global max, when maxPathSum(root.left)+maxPathSum(root.right)+root.key>globalmax
        // 3.what will return to parent?
        //    return Math.max(leftsum,rightsum)+root.key

        int[] global = new int[1];
        global[0] = Integer.MIN_VALUE;
        int temp = recurMaxPathSum(root,global);
        return global[0];

    }

    private int recurMaxPathSum(TreeNode root, int[] global){
        //base case
        if (root == null){
            return 0;
        }

        //except from child

        int left =  recurMaxPathSum(root.left,global);
        int right = recurMaxPathSum(root.right,global);
        if (root.left != null && root.right != null){ //not same leaf node
            global[0] = Math.max(global[0],left+right+root.key);
        }else if (root.left != null || root.right != null){
            return root.left != null? root.key+left : root.key+right;
        }

        return Math.max(left,right)+root.key;
    }
    public static void main(String[] args){
        MaximumPathSumBinaryTreeI test = new MaximumPathSumBinaryTreeI();
        TreeNode n1 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(-4);
        n1.left = n2;
        n2.left = n3;
        TreeNode n4 = new TreeNode(-3);
        TreeNode n5 = new TreeNode(-5);
        n1.right = n4;
        n4.right = n5;
        System.out.println(test.maxPathSum(n1));
    }
}
class TreeNode {
   public int key;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int key) {
     this.key = key;
   }
}
