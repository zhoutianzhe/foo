package com.zrl.algorithm;

/**
 * @author zrl
 * @date 2024/5/6 23:51
 * @description xxx
 */
public class Te {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        ListNode ans = addTwoNumbers(l1, l2);
        while(ans!=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int inrc = 0;
        ListNode ans = null;
        ListNode end = null;
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        while(ll1!=null || ll2!=null){
            int preinrc = inrc;
            inrc = 0;
            int val1 = 0;
            if(ll1!=null){
                val1 = ll1.val;
                ll1 = ll1.next;
            }
            int val2 = 0;
            if(ll2!=null){
                val2 = ll2.val;
                ll2 = ll2.next;
            }
            int total = val1 + val2 + preinrc;
            int val = total;
            if(total>=10){
                val = total - 10;
                inrc = 1;
            }
            ListNode node = new ListNode(val);
            if(ans == null){
                ans = node;
            }
            if(end == null){
                end = ans;
            }else{
                end.next = node;
                end = node;
            }
        }
        if(inrc!=0){
            ListNode node = new ListNode(inrc);
            end.next = node;
        }
        return ans;
    }
}
