package com.zrl.algorithm;

import java.util.*;

/**
 * @Author riliang.zrl
 * @Date 2024/5/27 17:11
 * @Description
 **/
public class OrangesRotting {

    public static void main(String[] args) {
//        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid = {{0,2,2}};
        OrangesRotting obj = new OrangesRotting();
        int ans = obj.orangesRotting(grid);
        System.out.println(ans);
    }

    int freshNum = 0;
    Queue<int[]> queue = new LinkedList();
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rlen = grid.length;
        int clen = grid[0].length;

        for (int r = 0; r < rlen; r++) {
            for (int c = 0; c < clen; c++) {
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r,c});
                }else if(grid[r][c] == 1){
                    freshNum++;
                }
            }
        }
        int depath = 0;
        while(!queue.isEmpty()){
            depath++;
            int nums = queue.size();
            for (int i = 0; i < nums; i++) {
                int[] rc = queue.remove();
                int r = rc[0];
                int c = rc[1];
                fl(grid, r-1, c);
                fl(grid, r+1, c);
                fl(grid, r, c-1);
                fl(grid, r, c+1);
            }
        }
        return freshNum > 0 ? -1 : depath;
    }

    private void fl(int[][] grid, int r, int c) {
        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 1){
            grid[r][c] = 2;
            queue.add(new int[]{r,c});
            freshNum--;
        }
    }

}
