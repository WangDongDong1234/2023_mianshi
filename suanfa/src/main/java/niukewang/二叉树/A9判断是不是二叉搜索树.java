package niukewang.二叉树;

import niukewang.common.TreeNode;

/**
 * 这里没有看懂
 */
public class A9判断是不是二叉搜索树 {
    private int min = Integer.MIN_VALUE;  //因为右子书的最小节点比根节点大，不能忽视这个
    public boolean isValidBST (TreeNode root) {
        // write code here
        if (root == null) return true;
        //处理左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        //处理当前节点  注意（二叉树做前必看）
        if (min >= root.val) {
            return false;
        } else {
            min = root.val;
        }
        //处理右子树
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;

    }
}
