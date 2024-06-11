package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  //重点是这个
 *         if (inStart > inEnd) {
 *             return null;
 *         }
 */
public class B2中序和后序 {
    // 存储所有节点的映射，方便查找
    Map<Integer, Integer> indexMap;
    // 存储所有节点的数组
    int[] postorder;
    int[] inorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return recur(0, inorder.length - 1, 0, postorder.length - 1);
    }

    // 递归构建二叉树
    private TreeNode recur(int inStart, int inEnd, int postStart, int postEnd) {
        //重点是这个
        if (inStart > inEnd) {
            return null;
        }
        // 根节点在后序数组的最后一个元素
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        // 找到根节点在中序数组的位置
        int index = indexMap.get(rootVal);
        // 左子树节点数量
        int leftSize = index - inStart;
        // 构建左子树
        root.left = recur(inStart, index - 1, postStart, postStart + leftSize - 1);
        // 构建右子树
        root.right = recur(index + 1, inEnd, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        B2中序和后序 t=new B2中序和后序();
        int[] mid={9,3,15,20,7};
        int[] pos={9,15,7,20,3};
        TreeNode result =t.buildTree(mid,pos);
        System.out.println("OK");
    }
}
