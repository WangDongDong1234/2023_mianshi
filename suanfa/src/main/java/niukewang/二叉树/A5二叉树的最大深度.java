package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.LinkedList;

public class A5二叉树的最大深度 {
    public int maxDepth (TreeNode root) {
        // write code here
        if(root==null){return 0;}

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }

    public int maxDepth2(TreeNode root){
        if(root==null){
            return 0;
        }

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int depth=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode cur=queue.pollFirst();
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
                size--;
            }
            depth++;
        }

        return depth;

    }
}
