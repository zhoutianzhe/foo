package com.zrl.algorithm;

import java.util.*;

/**
 * @Author riliang.zrl
 * @Date 2024/5/27 13:57
 * @Description
 **/
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            //i指的是列
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }



    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens2(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> leftRight = new HashSet<>();
        Set<Integer> rightLeft = new HashSet<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        backtrack2(n, 0, queue, columns, leftRight, rightLeft);
        return ans;
    }

    //10
    private void backtrack2(int n, int row, int[] queue, Set<Integer> columns, Set<Integer> leftRight, Set<Integer> rightLeft){
        if(row == n){
            //生成结果
            List<String> ansItem = generateBoard2(queue);
            ans.add(ansItem);
            return;
        }
        for(int i=0; i<n; i++){
            if(columns.contains(i)){
                continue;
            }
            int lr = i-row;
            if(leftRight.contains(lr)){
                continue;
            }
            int rl = i+row;
            if(rightLeft.contains(rl)){
                continue;
            }
            queue[row] = i;
            columns.add(i);
            leftRight.add(lr);
            rightLeft.add(rl);
            backtrack2(n, row+1, queue, columns, leftRight, rightLeft);
            queue[row] = -1;
            columns.remove(i);
            leftRight.remove(lr);
            rightLeft.remove(rl);
        }
    }

    public List<String> generateBoard2(int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            char[] row = new char[queens.length];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            list.add(new String(row));
        }
        return list;
    }



}
