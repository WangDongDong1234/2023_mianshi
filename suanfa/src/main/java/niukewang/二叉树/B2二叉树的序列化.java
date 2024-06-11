package niukewang.二叉树;

import niukewang.common.TreeNode;

/**
 * 这里没有看懂
 */
public class B2二叉树的序列化 {
    public int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if(root == null){
            s.append("#,");
            return s.toString();
        }
        s.append(root.val+",");
        s.append(Serialize(root.left));
        s.append(Serialize(root.right));
        return s.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] DLRseq = str.split(",");
        TreeNode leave = null;
        if(!DLRseq[index].equals("#")){
            leave = new TreeNode(Integer.valueOf(DLRseq[index]));

            //  这里没有看懂
            leave.left = Deserialize(str);
            leave.right = Deserialize(str);
        }
        return leave;
    }
}
