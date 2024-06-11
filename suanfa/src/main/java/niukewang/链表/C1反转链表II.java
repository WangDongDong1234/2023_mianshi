package niukewang.链表;

import niukewang.common.ListNode;

public class C1反转链表II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index=0;
        ListNode temp=head;
        while(temp!=null){
            index++;
            temp=temp.next;
        }

        int[] array=new int[index];
        ListNode temp2=head;
        int index2=0;
        while(temp2!=null){
            array[index2]=temp2.val;
            index2++;
            temp2=temp2.next;
        }

        int start=0;
        int end=index-1;
        boolean boolean1=true;
        boolean boolean2=true;
        while(start<end){
            while(start<left-1&&boolean1){
                start++;
                boolean1=false;
            }
            while(end>=right&&boolean2){
                end--;
                boolean2=false;
            }
            int temp1=array[start];
            array[start]=array[end];
            array[end]=temp1;
            start++;
            end--;
        }

        ListNode res=new ListNode(-1);
        ListNode tail=res;
        for(int i=0;i<array.length;i++){
            ListNode t=new ListNode(array[i]);
            res.next=t;
            res=res.next;
        }

        return tail.next;



    }


    public static void main(String[] args) {
        C1反转链表II start =new C1反转链表II();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode tt=start.reverseBetween(l1,2,4);
        System.out.println(l1);
    }
}
