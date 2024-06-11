package niukewang.二叉树;

import niukewang.common.TreeNode;

public class A11判断是不是平衡二叉树 {

    public boolean IsBalanced_Solution (TreeNode pRoot) {
        // write code here
        if(pRoot==null){
            return true;
        }

        return helper(pRoot)!=-1;
    }

    // 返回-1 表示非平衡
    public int helper(TreeNode cur){
        if(cur==null){
            return 0;
        }

        int leftDepth=helper(cur.left);
        int rightDepth=helper(cur.right);
        int diff=leftDepth-rightDepth;
        //注意（二叉树做前必看）  判断是否是平衡二叉树，不光要保证跟节点，还要保证每个节点都是
        if(leftDepth==-1||rightDepth==-1||(diff<-1||diff>1)){
            return -1;
        }

        return Math.max(leftDepth,rightDepth)+1;

    }
}
