package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class A10判断是不是完全二叉树 {
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;

        // 如果是完全二叉树，只要出现一次null，后面就必须是null
        boolean flag = false;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur == null){
                flag = true;
                continue;
            }
            if(flag) return false;
            //注意（二叉树做前必看）  注意顺序问题
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }
}
