package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class C5二叉树右视图20240605 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root ==null){
            return result;
        }

        LinkedList<TreeNode> queue=new LinkedList();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                TreeNode temp=queue.pollFirst();
                if(size==1){
                    result.add(temp.val);
                }
                if(temp.left!=null){
                    queue.addLast(temp.left);
                }
                if(temp.right!=null){
                    queue.addLast(temp.right);
                }
                size--;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        C5二叉树右视图20240605 start =new C5二叉树右视图20240605();
        TreeNode treeNode1 =new TreeNode(1);
        TreeNode treeNode2 =new TreeNode(2);
        TreeNode treeNode3 =new TreeNode(3);
        TreeNode treeNode4 =new TreeNode(4);
        TreeNode treeNode5 =new TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.right=treeNode5;
        treeNode3.right=treeNode4;

        start.rightSideView(treeNode1);
    }
}
