package javaclass;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class inOrderiterative {
    public List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode helper = root;
        while (helper != null || !stack.isEmpty()){
            if (helper != null){
                stack.offerFirst(helper);
                helper = helper.left;
            }
            if (helper == null){
                TreeNode temp = stack.peekFirst();
                res.add(temp.val);
                stack.pollFirst();
                helper = temp.right;
            }
        }
        return res;
    }
    public static void main(String[] args){
        inOrderiterative test = new inOrderiterative();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(9);
        n2.right = n5;
        n2.left = n4;
        n3.right = n6;
        System.out.println(test.inOrder(n1));
    }
}
