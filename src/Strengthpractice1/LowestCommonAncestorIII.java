package Strengthpractice1;

class TreeNode {
  public int key;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(int key) {
      this.key = key;
  }
}

public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // write your solution here
        //Assumption: no parent pointer, 2 nodes not guaranteed in the binary tree
        // need add post-processing based on LCAI

        //result of LCA I(2 nodes guaranteed in the binary tree)
        TreeNode res = LCAI(root,one,two);

        //post-processing

        if (res != one && res != two){  // means two nodes are in tree
            return res;
        }else if(res == one || res == two){
            //one node is the ancestor of the other, not sure the child one exist
            TreeNode child = res==one ? two : one;
            if (!findChild(res,child)){ // child node not exist
                return null;
            }
        }
        return res;



    }
    private TreeNode LCAI(TreeNode root, TreeNode one, TreeNode two){
        //base case
        if (root == null || root == one || root == two){
            return root;
        }
        //Recursion
        // expected from child subtree
        TreeNode left = LCAI(root.left, one, two);
        TreeNode right = LCAI(root.right, one, two);
        // report to parent(return value)
        if (left != null && right != null){
            return root;
        }else if (left != null || right != null){
            return left==null ? right : left;
        }
        return null;
    }

    private boolean findChild(TreeNode root, TreeNode node){
        //base case
        if (root == null){
            return false;
        }
        if (root == node){
            return true;
        }
        //recursion
        // expect from subtree
        boolean left = findChild(root.left, node);
        boolean right = findChild(root.right, node);
        if (left || right){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        LowestCommonAncestorIII test = new LowestCommonAncestorIII();
        TreeNode root1 = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        root1.left = a;
        root1.right = b;
        System.out.println(test.lowestCommonAncestor(root1,a,b));
    }

}
