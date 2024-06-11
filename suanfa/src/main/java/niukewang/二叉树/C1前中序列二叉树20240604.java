package niukewang.二叉树;

import niukewang.common.TreeNode;

import java.util.HashMap;

public class C1前中序列二叉树20240604 {

    private HashMap<Integer,Integer> map=new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int preLeft,int preRight, int[] inorder,int inLeft,int inRight){
        // 此处不能等于，等于的时候说明只有一个结点
        if(preLeft>preRight){
            return null;
        }

        int rootValue=preorder[preLeft];
        // 此处计算长度注意
        int index=map.get(rootValue);
        int length=index-inLeft;
        TreeNode root=new TreeNode(rootValue);

        //中间位置取错
        root.left=build(preorder,preLeft+1,preLeft+length,inorder,inLeft,index-1);
        root.right=build(preorder,preLeft+length+1,preRight,inorder,index+1,inRight);
        return root;

    }

    public static void main(String[] args) {
        C1前中序列二叉树20240604 start =new C1前中序列二叉树20240604();
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        TreeNode treeNode = start.buildTree(preorder,inorder);
        System.out.println(treeNode);
    }
}
