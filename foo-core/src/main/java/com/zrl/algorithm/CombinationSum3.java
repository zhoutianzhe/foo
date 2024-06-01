package com.zrl.algorithm;

import java.util.*;

/**
 * @Author riliang.zrl
 * @Date 2024/5/28 23:35
 * @Description LC 216
 **/
public class CombinationSum3 {

    public static void main(String[] args) {
        CombinationSum3 obj = new CombinationSum3();
        obj.combinationSum3(3,9);
        System.out.println(obj.ans);
    }

    List<List<Integer>> ans = new ArrayList();
    List<Integer> temp = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        dfs(nums, k, n, 0);
        return ans;
    }

    private void dfs(int[] nums, int k, int n, int start) {
        if(n==0 && temp.size() == k){
            ans.add(new ArrayList(temp));
            return;
        }
        if(temp.size() == k){
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(nums[i]>n){
                break;
            }
            temp.add(nums[i]);
            dfs(nums, k, n-nums[i], i+1);
            temp.remove(temp.size()-1);
        }
    }

}
