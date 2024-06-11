package likou;

import niukewang.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class A1蛇形打印二叉树 {
    public  ArrayList<ArrayList<Integer>> zigzagOrder(TreeNode root) {

        int level = 1;
        Stack<TreeNode> stack1 = new Stack<>();  //栈1存奇数节点
        stack1.push(root);   //将根节点入栈
        Stack<TreeNode> stack2 = new Stack<>();  //栈2存偶数节点
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (!stack1.empty() || !stack2.empty()) {
            if (level % 2 != 0) {  //奇数层,该层为奇数层，叶子节点从右向左入栈，所以该层的叶子节点应入偶数栈
                ArrayList<Integer> t = new ArrayList<>();
                while (!stack1.empty()) {
                    TreeNode cur = stack1.pop();
                    if (cur != null) {
                        t.add(cur.val);
                        stack2.push(cur.left);
                        stack2.push(cur.right);
                    }
                }
                if (!t.isEmpty()) {
                    list.add(t);
                    level++;
                }
            } else {
                ArrayList<Integer> t = new ArrayList<>();
                while (!stack2.empty()) {
                    TreeNode cur = stack2.pop();
                    if (cur != null) {
                        t.add(cur.val);
                        stack1.push(cur.right);
                        stack1.push(cur.left);
                    }
                }
                if (!t.isEmpty()) {
                    list.add(t);
                    level++;
                }
            }

        }
        return list;
    }


}
