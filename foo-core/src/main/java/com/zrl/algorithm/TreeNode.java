package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/27 11:55
 * @Description
 **/
public class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}
