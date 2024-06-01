package com.zrl.algorithm;

import java.util.Arrays;

/*
 * @author  wuluo
 * @Date 2024/4/8 19:51
 * @Description
 **/
public class MaxSlidingWindow {

    public static void main(String[] args)
    {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int i : result)
        {
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length<k?0:nums.length-k+1;
        int[] ans = new int[length];
        if(nums.length<k){
            ans[0]= Arrays.stream(nums).max().getAsInt();
            return ans;
        }
        for(int i =0; i<nums.length-k+1; i++){
            int[] a = Arrays.copyOfRange(nums, i, i+k);
            int r = Arrays.stream(a).max().getAsInt();
            ans[i] =r;
        }
        return ans;
    }

}
