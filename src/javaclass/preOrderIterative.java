package javaclass;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class preOrderIterative {
    public List<Integer> preOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pollFirst();
            res.add(temp.val);
            if (temp.right != null){
                stack.offerFirst(temp.right);
            }
            if (temp.left != null){
                stack.offerFirst(temp.left);
            }
        }
        return res;

    }
    public static void main(String[] args){
        preOrderIterative test = new preOrderIterative();
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
        System.out.println(test.preOrder(n1));
    }
}

class TreeNode {
    int val;
    TreeNode right = null;
    TreeNode left = null;
    public TreeNode(int val){//构造函数没有返回类型
        this.val = val;
    }
}
