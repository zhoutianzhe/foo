package com.zrl.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author riliang.zrl
 * @Date 2024/5/23 16:52
 * @Description
 **/
public class Rotate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        Rotate rotate = new Rotate();
        rotate.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k==0 || len==1){
            return;
        }
        LinkedList<Integer> list = new LinkedList();
        for (int num : nums) {
            list.addLast(num);
        }
        for(int i=0;i<k;i++){
            list.addFirst(list.removeLast());
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.pop();
        }
    }

}
