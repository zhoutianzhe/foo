package com.zrl.algorithm;

/**
 * @Author riliang.zrl
 * @Date 2024/5/27 16:18
 * @Description
 **/
public class NumIslands {

    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rlen = grid.length;
        int clen = grid[0].length;
        int ans = 0;
        //先按行、再按列嵌套遍历
        for(int r=0;r<rlen;r++){
            for(int c=0;c<clen;c++){
                if(grid[r][c] == '1'){
                    ans++;
                    dfs(grid, r, c);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rlen = grid.length;
        int clen = grid[0].length;
        if(r<0 || c<0 || r>=rlen || c>=clen || grid[r][c]=='0'){
            return;
        }
        //关键：遍历过的地方设置成0
        grid[r][c] = '0';
        dfs(grid, r-1,c);
        dfs(grid, r+1,c);
        dfs(grid, r,c-1);
        dfs(grid, r,c+1);
    }

}
