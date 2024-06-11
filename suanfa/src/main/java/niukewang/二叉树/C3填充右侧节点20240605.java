package niukewang.二叉树;

import niukewang.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class C3填充右侧节点20240605 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }

        LinkedList<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            Node pre =null;
            while(size>0){
                Node node =queue.pollLast();
                Node cur =null;
                if(node.right!=null){
                    cur =node.right;
                    queue.addFirst(node.right);
                    if(pre==null){
                        pre=cur;
                    }else{
                        cur.next=pre;
                        pre=cur;
                    }

                }
                if(node.left!=null){
                    cur =node.left;
                    queue.addFirst(node.left);
                    if(pre==null){
                        pre=cur;
                    }else{
                        cur.next=pre;
                        pre=cur;
                    }
                }
                size--;
            }
        }

        return root;

    }

    public static void main(String[] args) {
        C3填充右侧节点20240605 start =new C3填充右侧节点20240605();
        Node node1 =new Node(1);
        Node node2 =new Node(2);
        Node node3 =new Node(3);
        Node node4 =new Node(4);
        Node node5 =new Node(5);
        Node node7 =new Node(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node7;

        start.connect(node1);

        LinkedList<Integer> queue=new LinkedList<Integer>();
        queue.add(4); //右加
        queue.add(5); //右加
        queue.addLast(6); //右加
        queue.addFirst(3); //左加
        queue.addFirst(2); //左加
        queue.poll();  //左减
        queue.pollFirst();//左减
        queue.pollLast();//右减
        System.out.println(queue);
    }

}
