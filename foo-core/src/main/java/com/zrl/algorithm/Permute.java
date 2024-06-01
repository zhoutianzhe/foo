package com.zrl.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author riliang.zrl
 * @Date 2024/5/13 10:21
 * @Description LC 46 全排列
 * 10:28
 * 10：43
 **/
public class Permute {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        down(ans, list, n, 0);
        return ans;
    }

    private static void down(List<List<Integer>> ans, List<Integer> list, int n, int first) {
        if(first == n){
            ans.add(new ArrayList<>(list));
        }
        //变量不要搞错
        for (int j = first; j<n ;j++){
            // 交换的变量不要搞错
            Collections.swap(list, first, j);
            down(ans, list, n, first+1);
            //要记得恢复
            Collections.swap(list, j, first);
        }
    }

}
