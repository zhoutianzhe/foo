package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/10 16:42
 * @Description
 **/
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,6,2,8,4};
        System.out.println(arr);
        int[] newarr = mergeSort(arr);
        System.out.println(newarr);
    }


    //归并
    public static int[] mergeSort(int[] arr){
        int[] temp = new int[arr.length];

        doMergeSort(arr, 0, arr.length-1, temp);

        System.out.println(arr);

        return arr;
    }

    public static void doMergeSort(int[] arr, int left, int right, int[] temp){
        if(left<right){
            int mid = (left + right)/2;
            doMergeSort(arr, left, mid, temp);
            doMergeSort(arr, mid+1, right, temp);
            merge(arr, left, right, mid, temp);
        }
    }

    public static void merge(int[] arr, int left, int right, int mid, int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;

        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }

        while(i<=mid){
            temp[t++] = arr[i++];
        }
        while(j<=right){
            temp[t++] = arr[j++];
        }

        t = 0;

        while(left<=right){
            arr[left++] = temp[t++];
        }
    }


        //冒泡
    public static int[] bubbleSort(int[] arr){
        int l = arr.length;
        for(int i=0; i<l ;i++){
            for(int j=0; j<l-i-1 ;j++){
                swap(arr,j,j+1);
            }
        }
        return arr;
    }

    //插入
    public static int[] insertSort(int[] arr){
        int l = arr.length;
        for(int i=1; i<l ;i++){
            for(int j=i; j>0 ;j--){
                swap(arr,j-1,j);
            }
        }
        return arr;
    }

    private static void swap(int[] arr,int i, int j){
        if(arr[i]>arr[j]){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

}
