package com.zrl.algorithm;

import java.util.*;

/**
 * @Author riliang.zrl
 * @Date 2024/5/29 00:25
 * @Description
 **/
public class CombinationSum2 {

    List<List<Integer>> ans = new ArrayList();
    List<Integer> temp = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //关键步骤
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, int start) {
        if(target == 0){
            ans.add(new ArrayList(temp));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if(target<candidates[i]){
                break;
            }
            //处理去重的关键
            //小剪枝：同一层相同数值的结点，从第2个开始，候选数更少，结果一定发生重复，因此跳过，用continue(不是break！！)
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }

            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}
