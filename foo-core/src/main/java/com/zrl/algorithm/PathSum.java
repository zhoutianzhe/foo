package com.zrl.algorithm;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author riliang.zrl
 * @Date 2024/5/27 11:39
 * @Description
 **/
public class PathSum {

    public static void main(String[] args) {
        PathSum obj = new PathSum();
//        1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000
        TreeNode node = new TreeNode(1000000000);
        TreeNode node2 = new TreeNode(1000000000);
        TreeNode node3 = new TreeNode(294967296);
        TreeNode node4 = new TreeNode(1000000000);
        TreeNode node5 = new TreeNode(1000000000);
        TreeNode node6 = new TreeNode(1000000000);
        node.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        node5.left = node6;
        int ans = obj.pathSum(node, 0);
        System.out.println(ans);
    }

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    //node, sum
    Map<TreeNode, List<Long>> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        //遍历
        down(root, null);

        //计算统计
        Long target = Long.valueOf(targetSum);
        AtomicInteger ans = new AtomicInteger(0);
        map.forEach((k,v)->{
            for (Long integer : v) {
                if(target.equals(integer)){
                    ans.getAndIncrement();
                }
            }
        });
        return ans.get();
    }

    public void down(TreeNode node, TreeNode parent){
        if(node == null){
            return;
        }
        parentMap.put(node, parent);
        List<Long> list = new ArrayList<>();
        if(parent != null){
            List<Long> plist = map.get(parent);
            copy(list, plist);
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i)+ node.val);
            }
        }
        list.add(Long.valueOf(node.val));
        map.put(node, list);

        down(node.left, node);
        down(node.right, node);
    }

    private void copy(List<Long> dest, List<Long> src){
        for (Long integer : src) {
            dest.add(integer);
        }
    }

}
