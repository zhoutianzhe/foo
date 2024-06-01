package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/25 00:38
 * @Description
 **/
public class Rotate2 {

    public static void main(String[] args) {
        Rotate2 r2= new Rotate2();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        r2.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top=0,bottom=n-1;
        int temp = 0;
        while(top<bottom){
            for(int i=0; i<n; i++){
                temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
            }
            top++;
            bottom--;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

}
