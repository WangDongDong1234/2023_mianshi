package niukewang.二叉树;

import niukewang.common.TreeNode;

public class A7合并二叉树 {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1==null&&t2==null){
            return null;
        }

        if(t1!=null&&t2==null){
            return t1;
        }

        if(t2!=null&&t1==null){
            return t2;
        }


        t1.val+=t2.val;
        //注意（二叉树做前必看）
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);

        return t1;
    }
}
