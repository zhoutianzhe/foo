package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/11 14:52
 * @Description 16:24
 **/
public class Tesx {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length-1);

    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = (r+l)/2;
        ListNode lNode = merge(lists, 0, mid);
        ListNode rNode = merge(lists, mid+1, r);
        return mergeTwo(lNode, rNode);
    }

    private ListNode mergeTwo(ListNode lNode, ListNode rNode) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy, temp1=lNode, temp2=rNode;
        while(temp1!=null&&temp2!=null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1!=null){
            temp.next = temp1;
        }
        if(temp2!=null){
            temp.next = temp2;
        }
        return dummy.next;
    }


}
