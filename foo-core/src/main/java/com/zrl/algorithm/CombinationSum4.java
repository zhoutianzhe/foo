package com.zrl.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author riliang.zrl
 * @Date 2024/5/28 23:09
 * @Description LETCODE 377
 **/
public class CombinationSum4 {

    public static void main(String[] args) {
        CombinationSum4 obj = new CombinationSum4();
        int[] nums = {1,2,3};
        obj.combinationSum4(nums, 4);
    }

    List<Integer> temp = new ArrayList<>();
    int ans = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target);
        System.out.println(ans);
        return ans;
    }

    private void dfs(int[] nums, Integer target) {
        if(target == 0){
            ans++;
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(target<nums[i]){
                break;
            }
            temp.add(nums[i]);
            dfs(nums, target-nums[i]);
            temp.remove(temp.size()-1);
        }
    }

}
