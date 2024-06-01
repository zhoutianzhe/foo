package com.zrl.algorithm;

import java.util.*;

/*
 * @author  wuluo
 * @Date 2024/4/7 14:09
 * @Description
 **/
public class ThreeSumSolution {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum2(nums));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 3)));
        Arrays.stream(nums).max().getAsInt();
    }


    /**
     * 暴力遍历
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            List<Integer> set = map.get(nums[i]);
            if(set == null){
                set = new ArrayList<>();
            }
            set.add(i);
            map.put(nums[i], set);
        }
        Set<String> ditinct = new HashSet();
        List<List<Integer>> result = new ArrayList();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1; j<nums.length-1;j++){
                int a = 0 - (nums[i] + nums[j]);
                if(!map.containsKey(a)){
                    continue;
                }
                List<Integer> ss = map.get(a);
                for(int s: ss){
                    if(s!=i && s!=j){
                        List r = new ArrayList();
                        r.add(nums[i]);
                        r.add(nums[j]);
                        r.add(a);
                        Collections.sort(r);
                        String ditinctKey = ""+r.get(0)+r.get(1);
                        if(!ditinct.contains(ditinctKey)){
                            result.add(r);
                            ditinct.add(ditinctKey);
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result =  new ArrayList();

        for(int k=0; k<nums.length -2; k++){
            if(nums[k] > 0){
                break;
            }
            if(k > 0 && nums[k] == nums[k - 1]) continue;  //关键行
            int i = k+1;
            int j = nums.length-1;
            while(i<j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum<0){
                    while(i<j && nums[i]==nums[++i]);
                }else if (sum>0){
                    while(i<j && nums[j]==nums[--j]);
                }else{
                    List<Integer> r = new ArrayList();
                    r.add(nums[i]);
                    r.add(nums[j]);
                    r.add(nums[k]);
                    result.add(r);
                    while(i<j && nums[i]==nums[++i]);
                    while(i<j && nums[j]==nums[--j]);
                }
            }
        }
        return result;
    }




}
