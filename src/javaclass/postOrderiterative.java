package javaclass;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class postOrderiterative {
    public List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null; //record the direction we are taking now and decide the next direction
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peekFirst();
            if(pre == null || pre.right == cur || pre.left == cur){ //going down
                if (cur.left != null){
                    stack.offerFirst(cur.left);
                    pre = cur;
                }else if (cur.right != null){
                    stack.offerFirst(cur.right);
                    pre = cur;
                }else{
                    pre = stack.pollFirst();
                    res.add(pre.val);
                }
            }else if (pre == cur.left){
                pre = cur;
                stack.offerFirst(cur.right);
            }else if (pre == cur.right){
                pre = stack.pollFirst();
                res.add(pre.val);
            }
        }
        return res;
    }

    public static void main(String[] args){
        postOrderiterative test = new postOrderiterative();
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
        System.out.println(test.postOrder(n1));
    }
}
