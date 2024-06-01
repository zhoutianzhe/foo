package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/23 14:24
 * @Description
 **/
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray obj = new MaxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int a = obj.maxSubArray(nums);
        System.out.println(a);
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int pre = nums[0];
        int max = pre;
        for(int i=1;i<len;i++){
            if(pre>0){
                pre = pre+nums[i];
            }else{
                pre=0+nums[i];
            }
            if(pre>max){
                max = pre;
            }
        }
        return max;
    }
}
