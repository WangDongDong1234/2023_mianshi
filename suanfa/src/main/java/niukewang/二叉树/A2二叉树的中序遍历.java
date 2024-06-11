package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.List;
import java.util.Stack;

public class A2二叉树的中序遍历 {
    public void inorder(TreeNode root, List result){
        if(root==null){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

    public void inorder2(TreeNode root,List result) {
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // 中序遍历在这写
            result.add(cur.val);
            cur = cur.right;

        }
    }

}
