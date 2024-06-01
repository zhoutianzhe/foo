package com.zrl.algorithm;

import com.zrl.algorithm.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author riliang.zrl
 * @Date 2024/5/10 15:09
 * @Description LC 138
 **/
public class TestCopyRandomList {

    public static void main(String[] args) {
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        Node head = copyRandomList(n0);
        System.out.println(head);
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Integer> map = new HashMap();
        List<Node> list = new ArrayList();
        Node hair = new Node(0);
        Node pre = hair;
        Node temp = head;
        int i = 0;
        while(temp != null){
            Node node = new Node(temp.val);
            pre.next = node;
            pre = node;
            map.put(temp, i);
            list.add(node);
            i++;
            temp = temp.next;
        }

        Node newTemp = hair.next;
        temp = head;
        while(temp != null){
            Node random = temp.random;
            Integer index = map.get(random);
            if(index != null){
                newTemp.random = list.get(index);
            }
            temp = temp.next;
            newTemp = newTemp.next;
        }

        return hair.next;
    }


}
