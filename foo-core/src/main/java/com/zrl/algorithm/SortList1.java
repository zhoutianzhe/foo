package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/11 10:42
 * @Description
 **/
public class SortList1 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(5);
        ListNode ans = sortList(head);
        System.out.println(ans);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        int length = 0;
        ListNode node = head;
        while(node!=null){
            length++;
            node = node.next;
        }
        ListNode dummyNode = new ListNode(0, head);
        for(int subLength=1; subLength<length; subLength <<= 1){
            ListNode prev = dummyNode, curr =  prev.next;
            while(curr!=null){
                ListNode head1 = curr;
                for(int i=1; i<subLength && curr.next!=null; i++){
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                //断开
                curr.next = null;
                curr = head2;
                for(int i=1; i<subLength && curr!=null && curr.next!=null; i++){
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr!=null){
                    next = curr.next;
                    //断开
                    curr.next = null;
                }
                ListNode merge = merge(head1,head2);
                prev.next = merge;
                while(prev.next!=null){
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyNode.next;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }
        if(temp1!=null){
            temp.next = temp1;
        }
        if(temp2!=null){
            temp.next = temp2;
        }
        return dummyHead.next;
    }

}
