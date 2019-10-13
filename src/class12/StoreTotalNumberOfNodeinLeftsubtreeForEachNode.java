package class12;

public class StoreTotalNumberOfNodeinLeftsubtreeForEachNode {
    public int storeTotalLeft(TreeNode root) {
        //base case
        if (root == null){
            return 0;
        }
        //expect from child
        int leftTotal = storeTotalLeft(root.left);
        int rightTotal = storeTotalLeft(root.right);

        //current layer
        root.totalLeft = leftTotal;

        //to the next layer
        return leftTotal+rightTotal+1;
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
        StoreTotalNumberOfNodeinLeftsubtreeForEachNode test = new StoreTotalNumberOfNodeinLeftsubtreeForEachNode();
        int total = test.storeTotalLeft(n8);
        System.out.println(n4.totalLeft);
        System.out.println(n5.totalLeft);
        System.out.println(n8.totalLeft);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    int totalLeft;
    TreeNode(int val) {
        this.val = val;
    }
}
