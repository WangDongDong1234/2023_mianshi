package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class C4求根节点到叶子节点数字之和20240605 {
    public List<String> result =new ArrayList<>();

    // 存在问题，节点有一个子节点就有问题。
    public int sumNumbers1(TreeNode root) {


        dfs1(root,"");
        int sum=0;
        for(int i=0;i<result.size();i++){
            sum+=Integer.valueOf(result.get(i));
        }

        return sum/2;

    }

    public void dfs1(TreeNode root,String s){
        if(root ==null){
            result.add(s);
            return;
        }else{
            s=s+root.val;
        }

        dfs1(root.left,s);
        dfs1(root.right,s);

    }


    public int sumNumbers(TreeNode root) {
        if(root ==null){
            return 0;
        }


        dfs(root,"");
        int sum=0;
        for(int i=0;i<result.size();i++){
            sum+=Integer.valueOf(result.get(i));
        }

        return sum;

    }

    public void dfs(TreeNode root,String s) {
        s += root.val;
        if (root.left == null && root.right == null) {
            result.add(s);
            return;
        }

        if (root.left != null) {
            dfs(root.left, s);
        }

        if (root.right != null) {
            dfs(root.right, s);
        }
    }





    public static void main(String[] args) {
        C4求根节点到叶子节点数字之和20240605 start =new C4求根节点到叶子节点数字之和20240605();

//        TreeNode node1_1 =new TreeNode(1);
//        TreeNode node1_2 =new TreeNode(2);
//        TreeNode node1_3 =new TreeNode(3);
//        node1_1.left=node1_2;
//        node1_1.right=node1_3;
//
//
//
//        int result = start.sumNumbers(node1_1);
//        System.out.println(result);

//        TreeNode node2_1 =new TreeNode(4);
//        TreeNode node2_2 =new TreeNode(9);
//        TreeNode node2_3 =new TreeNode(0);
//        TreeNode node2_4 =new TreeNode(5);
//        TreeNode node2_5 =new TreeNode(1);
//        node2_1.left=node2_2;
//        node2_1.right=node2_3;
//        node2_2.left=node2_4;
//        node2_2.right=node2_5;
//        int result2 = start.sumNumbers(node2_1);
//        System.out.println(result2);

//        TreeNode node3_1 =new TreeNode(4);
//        TreeNode node3_2 =new TreeNode(9);
//        TreeNode node3_3 =new TreeNode(0);
//        TreeNode node3_4 =new TreeNode(1);
//        node3_1.left=node3_2;
//        node3_1.right=node3_3;
//        node3_2.right=node3_4;
//        int result2 = start.sumNumbers(node3_1);
//        System.out.println(result2);


        TreeNode node4_1 =new TreeNode(0);
        TreeNode node4_2 =new TreeNode(1);
        node4_1.left=node4_2;


        int result = start.sumNumbers(node4_1);
        System.out.println(result);


    }
}
