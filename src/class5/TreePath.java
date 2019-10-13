package class5;

import java.util.ArrayList;
import java.util.List;

public class TreePath {
    public List<List<Integer>> findpath(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recursion(root,res,path);
        return res;
    }
    private void recursion(TreeNode root, List<List<Integer>> res, List<Integer> path) {
        if (root == null){
            return;
        }
        path.add(root.key);
        if (root.left == null && root.right == null){
            res.add(path);
            return;
        }
        recursion(root.left,res,path);
        recursion(root.right,res,path);

    }
    public static void main(String[] args){
        TreePath test = new TreePath();
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(10);
        n1.right = n3;
        n1.left = n2;
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(6);
        n2.left = n4;
        n2.right = n5;
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        n5.right = n7;
        n5.left = n6;
        TreeNode n8 = new TreeNode(14);
        n3.right = n8;
        System.out.println(test.findpath(n1));
    }
}
