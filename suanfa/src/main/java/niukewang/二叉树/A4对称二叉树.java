package niukewang.二叉树;

import niukewang.common.TreeNode;

public class A4对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return check(root.left,root.right);

    }

    public boolean check(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }

        if(left==null&&right!=null){
            return false;
        }

        if(left!=null&&right==null){
            return false;
        }

        //注意（二叉树做前必看），值不相等直接返回，值相等还要继续判断是否对称
        if(left.val!=right.val){
            return false;
        }

        return check(left.left,right.right)&&check(left.right,right.left);
    }
}
