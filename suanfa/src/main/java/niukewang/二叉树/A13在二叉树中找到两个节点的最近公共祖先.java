package niukewang.二叉树;

import niukewang.common.TreeNode;

/**
 * 这里没有看懂
 */
public class A13在二叉树中找到两个节点的最近公共祖先 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root==null) return -1;
        if(o1==root.val || o2==root.val) return root.val;
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right,o1,o2);
        if(left ==-1) return right;
        if(right ==-1)  return left;
        return root.val;
    }

}
