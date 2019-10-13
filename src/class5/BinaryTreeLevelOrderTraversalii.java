package class5;


import java.util.*;

public class BinaryTreeLevelOrderTraversalii {
    public List<Integer> levelOrderBottom(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        //如果该层的节点都没有子节点，则为最后一层！！
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> back = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean lastlevel = true;
            for (int i=0;i<size;i++){
                TreeNode cur = q.peek();
                if(cur.left!=null){
                    q.offer(cur.left);
                    lastlevel = false;
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                    lastlevel = false;
                }
                back.offer(q.poll());
            }
            if(lastlevel){
                break;
            }else{
                back.clear();
            }
        }
        while(!back.isEmpty()){
            res.add(back.poll().key);
        }
        return res;
    }

    public static void main(String[] args){
        BinaryTreeLevelOrderTraversalii result = new BinaryTreeLevelOrderTraversalii();
        //test case
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;
        System.out.println(result.levelOrderBottom(root1));

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
