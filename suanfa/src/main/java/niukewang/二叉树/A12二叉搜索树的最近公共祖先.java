package niukewang.二叉树;

import niukewang.common.TreeNode;

public class A12二叉搜索树的最近公共祖先 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // 随便给2个数，利用二叉搜索树的性质：

        // 如果两个值都小于根节点，说明祖先在左子树一侧
        if(p<root.val && q<root.val)
            return lowestCommonAncestor(root.left,p,q);
        // 如果两个值都大于根节点，说明祖先在右子树一侧
        if(p>root.val && q>root.val)
            return lowestCommonAncestor(root.right,p,q);
        // 剩最后一种情况：如果根节点的值恰好在两个给定值之间，这个根节点就是最近的公共祖先
        return root.val;
    }
}
