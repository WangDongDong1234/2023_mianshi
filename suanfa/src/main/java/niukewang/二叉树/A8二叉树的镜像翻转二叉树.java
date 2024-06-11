package niukewang.二叉树;

import niukewang.common.TreeNode;

/**
 * fan
 */
public class A8二叉树的镜像翻转二叉树 {
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot==null){
            return null;
        }
        // write code here
        TreeNode left=Mirror(pRoot.left);
        TreeNode right=Mirror(pRoot.right);
        pRoot.left=right;
        pRoot.right=left;
        return pRoot;

    }
}
