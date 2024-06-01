package com.zrl.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author riliang.zrl
 * @Date 2024/5/23 14:38
 * @Description
 **/
public class MergeArr {

    public static void main(String[] args) {
//        [[2,3],[4,5],[6,7],[8,9],[1,10]]

        int[][] arr = new int[3][2];
        arr[0] = new int[]{2,3};
        arr[1] = new int[]{4,5};
        arr[2] = new int[]{1,8};
        MergeArr obj = new MergeArr();
        int[][] merge = obj.merge(arr);
        System.out.println(merge);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<List<Integer>> result = new ArrayList();
        List<Integer> item0 = toList(intervals[0]);
        result.add(item0);
        int len = intervals.length;
        for(int i=1;i<len;i++){
            List<Integer> a = toList(intervals[i]);
            int as = a.get(0);
            int ae = a.get(1);
            int j = result.size()-1;
            List<Integer> b = result.get(j);
            int bs = b.get(0);
            int be = b.get(1);
            if(bs==as && be==ae){
                continue;
            }
            if(be<as){
                result.add(a);
            }else if(be>=as && be <= ae){
                List<Integer> newList = new ArrayList<>();
                newList.add(bs);
                newList.add(ae);
                result.set(j, newList);
            }
        }

        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            int[] arr = new int[2];
            arr[0] = result.get(i).get(0);
            arr[1] = result.get(i).get(1);
            ans[i] = arr;
        }

        return ans;
    }

    private static List<Integer> toList(int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        list.add(arr[1]);
        return list;
    }

}
