package com.zrl.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author riliang.zrl
 * @Date 2024/5/28 16:49
 * @Description 全排列
 **/
public class Qpl {

    public static void main(String[] args) {
        int[] params = {1,2,3};
        Qpl qpl = new Qpl();
        qpl.permute(params);
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        trackback(nums,0, nums.length);
        return ans;
    }

    private void trackback(int[] nums, int cen, int n){
        if(cen == n){
            ans.add(copy(nums));
            return;
        }

        for(int i=cen; i<n; i++){
            swap(nums, cen, i);
            trackback(nums, cen+1, n);
            swap(nums, i, cen);
        }
    }

    private void swap(int[] nums, int cen, int i){
        int temp = nums[cen];
        nums[cen] = nums[i];
        nums[i] = temp;
    }

    private List<Integer> copy(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

}
