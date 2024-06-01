package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/9 15:26
 * @Description
 **/
public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = swapPairs(head);
        System.out.println(head);

    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode first = head;
        ListNode second = head.next;
        while(true){
            if(pre == null){
                head = second;
                first.next = second.next;
                second.next = first;
            }else{
                pre.next = second;
                first.next = second.next;
                second.next = first;
            }
            pre = first;
            first = first.next;
            if(first == null){
                break;
            }
            second = first.next;
            if(second == null){
                break;
            }
        }
        return head;
    }

}
