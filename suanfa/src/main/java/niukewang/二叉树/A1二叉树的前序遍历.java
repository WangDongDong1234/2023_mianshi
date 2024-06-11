package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.List;
import java.util.Stack;

public class A1二叉树的前序遍历 {

    /**
     * 递归二叉树遍历
     * @param root
     * @param result
     */
    public void preorder(TreeNode root, List result){
        if(root == null){
            return ;
        }
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }

    /**
     * 双重while+栈（二叉树打印1）
     * @param root
     * @param result
     */
    public void preorder2(TreeNode root,List result){
        Stack<TreeNode> stack=new Stack();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                //前序放这里
                result.add(cur.val);
                stack.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            // 中序遍历在这写
            //result.add(cur.val);
            cur=cur.right;
        }
    }
}
