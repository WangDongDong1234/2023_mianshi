package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class C2中后序列二叉树20240605 {

//    Map<Integer, Integer> inorderSet = new HashMap<>();
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        int index = 0;
//        for(int root : inorder)
//            inorderSet.put(root, index ++);
//
//        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
//
//    }
//
//    public TreeNode buildTree(int[] pre, int preL, int preR,
//                              int[] inorder, int inL, int inR){
//        if(inL>inR)
//            return null;
//
//        //    前序遍历第1个结点就是根结点
//        //    根据这个根结点可以到中序遍历序列中划分左右子树
//        //    先在中序遍历序列中找到这个根结点的索引
//        int inOrderRoot = inorderSet.get(pre[preR]);
//        //    根据中序遍历序列，计算左子树的长度 [左子树] inOrderRoot [右子树]
//        int subLen = inOrderRoot - inL;
//        //    建立根结点
//        TreeNode root = new TreeNode(pre[preR]);
//        //    创建左子树
//        //    前序遍历 preL,[preL + 1, preL + subLen]
//        //    后序遍历 [preL , preL + subLen] preL
//        //    中序遍历 [inL, inOrderRoot - 1]
//        root.left = buildTree(pre, preL , preL + subLen-1,
//                inorder, inL, inOrderRoot - 1);
//        //    创建右子树
//        //    前序遍历 preL,[preL + 1, preL + subLen],[preL + subLen + 1, preR]
//        //    后序遍历 [preL , preL + subLen],[preL + subLen + 1, preR-1]  preL
//        //    中序遍历 [inL, inOrderRoot - 1], inOrderRoot, [inOrderRoot + 1, inR]
//        root.right = buildTree(pre, preL + subLen, preR-1,
//                inorder, inOrderRoot + 1, inR);
//        //    最后返回这棵树
//        return root;
//
//    }


    private HashMap<Integer,Integer> map=new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);


    }

    public TreeNode buildTree(int[] inorder,int inleft,int inright, int[] postorder,int poleft,int poright){
        if(inleft>inright){
            return null;
        }

        int value=postorder[poright];
        int valueIndex=map.get(value);
        int length=valueIndex-inleft;
        TreeNode treeNode =new TreeNode(value);

        // 注意后续左右的范围，左子树是0到，0+length-1   此处犯错
        treeNode.left=buildTree(inorder,inleft,valueIndex-1,postorder,poleft,poleft+length-1);
        treeNode.right=buildTree(inorder,valueIndex+1,inright,postorder,poleft+length,poright-1);
        return treeNode;
    }
}
