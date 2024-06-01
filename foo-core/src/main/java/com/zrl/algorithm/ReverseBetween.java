package com.zrl.algorithm;

import java.util.*;

/**
 * @author zrl
 * @date 2024/5/31 09:51
 * @description xxx
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ReverseBetween obj = new ReverseBetween();
        ListNode node = new ListNode(3);
//        node.next = new ListNode(5);
//        node.next.next = new ListNode(6);
//        ListNode ans = obj.reverseBetween(node, 1, 2);
        ListNode newNode = obj.reverseLinkedList(node);
        System.out.println(newNode);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        List<ListNode> list = new ArrayList();
        int i=1;
        ListNode temp = head;
        ListNode nodeleft = null;
        ListNode noderight = null;
        while(i<=right+1){
            if(temp == null){
                break;
            }
            if(left-1==i){
                nodeleft = temp;
            }
            if(i==right+1){
                noderight = temp;
            }
            if(i>=left && i<=right){
                list.add(temp);
            }
            temp = temp.next;
            i++;
        }
        if(list.size()==1){
            return head;
        }

        ListNode tempHead = list.get(list.size()-1);

        for(int j=list.size()-1;j>0;j--){
            ListNode node = list.get(j);
            node.next = list.get(j-1);
        }

        if(noderight!=null){
            list.get(0).next = noderight;
        }else{
            list.get(0).next = null;
        }

        if(nodeleft == null){
            head = tempHead;
        }else{
            nodeleft.next = tempHead;
        }

        return head;
    }

    private ListNode reverseLinkedList(ListNode head) {
        //初始前一个节点为空节点
        ListNode pre = null;
        //初始当前节点为头节点
        ListNode cur = head;

        while (cur != null) {
            //1、准备动作：防止当前节点的next指针指向前一个节点丢失后一个节点，需要临时持有下一个节点
            ListNode next = cur.next;
            //2、反转：当前节点next指针指向前一个节点
            cur.next = pre;
            //3、为下次反转做准备
            //3.1 前驱指针指向当前节点 3.1 3.2步骤不能反一定先移动前驱指针，再移当前指针
            pre = cur;
            //3.2 当前指针指向下一个节点
            cur = next;
        }
        return pre;
    }

}



