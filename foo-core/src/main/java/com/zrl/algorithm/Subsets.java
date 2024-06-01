package com.zrl.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author riliang.zrl
 * @Date 2024/5/13 11:36
 * @Description LC 79 子集
 * 37
 **/
public class Subsets {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = subsets3(nums);
        System.out.println(ans);
    }

    //回溯
    public static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    //二进制位
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        // Math.pow(2, n) 二进制写法
        for(int i = (int)Math.pow(2, n); i<Math.pow(2,n+1); i++){
            // Integer.toBinaryString(i) 二进制string写法
            String a = Integer.toBinaryString(i).substring(1);
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(a.charAt(j) == '1'){
                    res.add(nums[j]);
                }
            }
            ans.add(res);
        }
        return ans;
    }


    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> subsets2(int[] nums) {
        down(0, nums);
        return ans;
    }

    private static void down(int i, int[] nums) {
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        down(i+1, nums);
        temp.remove(temp.size()-1);
        down(i+1, nums);
    }


}
