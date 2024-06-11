package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.List;
import java.util.Stack;

public class A3二叉树的后序遍历 {

    public void postorder(TreeNode root, List result){
        if(root==null){
            return;
        }
        postorder(root.left,result);
        postorder(root.right,result);
        result.add(root.val);
    }

    /**
     * （二叉树打印2）
     * @param root
     * @param result
     */
    public void postorder2(TreeNode root,List result){
        Stack<TreeNode> stack=new Stack();
        // 先前的节点
        TreeNode preTreeNode=null;
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            //cur.right==preTreeNode  右节点是否访问过
            if(cur.right==null||cur.right==preTreeNode){
                result.add(cur.val);
                preTreeNode=cur;
                cur=null;
            }else{
                stack.push(cur);
                cur=cur.right;
            }
        }
    }
}
