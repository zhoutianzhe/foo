package com.zrl.algorithm;

import java.util.*;

/**
 * @Author riliang.zrl
 * @Date 2024/5/28 22:33
 * @Description 39 组合总和
 **/
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = {8,7,4,3};
        obj.combinationSum(candidates, 11);

    }

    List<List<Integer>> ans = new ArrayList();
    List<Integer> temp = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, int start){
        if(target == 0){
            ans.add(new ArrayList(temp));
            return;
        }
        if(start==candidates.length){
            return;
        }

        for(int i = start; i<candidates.length; i++){
            int val = candidates[i];
            if(target<val){
                break;
            }
            temp.add(val);
            dfs(candidates, target - val, i);
            temp.remove(temp.size()-1);
        }
    }

}
