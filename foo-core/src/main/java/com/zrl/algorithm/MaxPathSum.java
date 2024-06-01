package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/27 15:20
 * @Description
 **/
public class MaxPathSum {

    public static void main(String[] args) {

    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if(node == null){
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftMax = Math.max(0, maxGain(node.left));
        int rightMax = Math.max(0, maxGain(node.right));

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int sum = node.val + leftMax + rightMax;

        // 更新答案
        maxSum = Math.max(maxSum, sum);

        //返回节点的最大贡献值
        return node.val + Math.max(leftMax, rightMax);
    }


}
