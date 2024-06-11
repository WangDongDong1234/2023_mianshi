package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树转双向链表
 */
public class A6二叉搜索树与双向链表 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }

        List<Integer> valuse=new ArrayList<>();
        midOrder(pRootOfTree,valuse);


        TreeNode head=null;
        if(valuse.size()>0){
            head=new TreeNode(valuse.get(0));
        }

        TreeNode pre=head;
        for(int i=1;i<valuse.size();i++){
            TreeNode temp = new TreeNode(valuse.get(i));
            temp.left=pre;
            pre.right=temp;
            pre=pre.right;

        }

        return head;

    }

    public void midOrder(TreeNode pRootOfTree,List valuse){
        if(pRootOfTree==null){
            return ;
        }
        midOrder(pRootOfTree.left,valuse);
        valuse.add(pRootOfTree.val);
        midOrder(pRootOfTree.right,valuse);
    }
}
