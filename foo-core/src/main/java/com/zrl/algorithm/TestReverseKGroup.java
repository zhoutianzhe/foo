package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/10 10:45
 * @Description
 **/
public class TestReverseKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseKGroup(head, 2);
        System.out.println(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;

        while(head!=null){
            ListNode tail = pre;
            for(int i=0; i<k; i++){
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            reverse(head, tail);
            pre.next = tail;
            head.next = nex;
            pre = head;
            head = head.next;
        }
        return hair.next;
    }

    private static void reverse(ListNode head, ListNode tail){
        ListNode pre = tail.next;
        ListNode curr = head;
        while(pre!=tail){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        if(k==1){
//            return head;
//        }
//        int size = 0;
//        ListNode temp = head;
//        while(temp != null){
//            size++;
//            temp = temp.next;
//        }
//        int batch = size/k;
//
//        ListNode pre = null;
//        ListNode first = head;
//        for(int i=1; i<=batch; i++){
//            int num = 1;
//            List<ListNode> group = new ArrayList();
//            while(first != null){
//                group.add(first);
//                first = first.next;
//                if(num==k){
//                    break;
//                }
//                num++;
//            }
//            swapGroup(group, k);
//            if(i == 1){
//                head = group.get(k-1);
//            }
//            if(pre!=null){
//                pre.next = group.get(k-1);
//            }
//            pre = group.get(0);
//            first = group.get(0).next;
//        }
//        return head;
//    }
//
//    private static void swapGroup(List<ListNode> group, int k){
//        ListNode next = group.get(k-1).next;
//        for(int j=k-1; j>0 ;j--){
//            ListNode node = group.get(j);
//            node.next = group.get(j-1);
//        }
//        group.get(0).next = next;
//    }

//    private ListNode swap(ListNode pre, ListNode first, ListNode second){
//        first.next = second.next;
//        second.next = first;
//        if(pre !=null){
//            pre.next = second;
//        }
//    }

}
