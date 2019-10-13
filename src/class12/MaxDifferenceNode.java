package class12;

public class MaxDifferenceNode {
    public TreeNode findMaxDifferenceNode(TreeNode root){
        //corner case
        if (root == null){
            return root;
        }
        TreeNode[] global = new TreeNode[1];
        global[0] = new TreeNode(Integer.MIN_VALUE);
        int totalNumber = findMaxDiff(root,global);
        return global[0];
    }
    private int findMaxDiff(TreeNode root, TreeNode[] global){
        //base case
        if (root == null){
            return 0;
        }
        //expect from child
        int left = findMaxDiff(root.left,global);
        int right = findMaxDiff(root.right, global);

        //current layer
        if (Math.abs(right-left) > global[0].val){
            global[0] = root;
        }

        //report to the parent node
        return left+right+1;
    }
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n8.left = n4;
        n8.right = n7;
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        n5.right = n6;
        MaxDifferenceNode test = new MaxDifferenceNode();
        TreeNode max = test.findMaxDifferenceNode(n8);
        System.out.println(max.val);
    }


}
