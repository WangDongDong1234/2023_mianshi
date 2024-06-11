package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class B1前序和中序 {
    //    前序遍历第1个节点必定是子树的根结点
    //    根据这个根结点，可以在中序遍历序列中划分左右子树
    Map<Integer, Integer> inorderSet = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        //    使用HashMap记录中序遍历序列的结点值和索引
        //    以便后期能够根据前序遍历的根结点，在中序遍历序列中划分左右子树
        int index = 0;
        for(int root : vin)
            inorderSet.put(root, index ++);

        return buildTree(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    public TreeNode buildTree(int[] pre, int preL, int preR,
                              int[] inorder, int inL, int inR){
        if(preL > preR)
            return null;

        //    前序遍历第1个结点就是根结点
        //    根据这个根结点可以到中序遍历序列中划分左右子树
        //    先在中序遍历序列中找到这个根结点的索引
        int inOrderRoot = inorderSet.get(pre[preL]);
        //    根据中序遍历序列，计算左子树的长度 [左子树] inOrderRoot [右子树]
        int subLen = inOrderRoot - inL;
        //    建立根结点
        TreeNode root = new TreeNode(pre[preL]);
        //    创建左子树
        //    前序遍历 preL,[preL + 1, preL + subLen]
        //    中序遍历 [inL, inOrderRoot - 1]
        root.left = buildTree(pre, preL + 1, preL + subLen,
                inorder, inL, inOrderRoot - 1);
        //    创建右子树
        //    前序遍历 preL,[preL + 1, preL + subLen],[preL + subLen + 1, preR]
        //    中序遍历 [inL, inOrderRoot - 1], inOrderRoot, [inOrderRoot + 1, inR]
        root.right = buildTree(pre, preL + subLen + 1, preR,
                inorder, inOrderRoot + 1, inR);
        //    最后返回这棵树
        return root;
    }
}
