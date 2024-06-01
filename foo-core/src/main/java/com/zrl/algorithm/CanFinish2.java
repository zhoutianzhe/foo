package com.zrl.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author riliang.zrl
 * @Date 2024/5/27 23:22
 * @Description 34
 **/
public class CanFinish2 {

    List<List<Integer>> edges;

    //下标表示课程id， 值表示入度
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        //初始哈
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }

        //初始化 indeg
        indeg = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] item = prerequisites[i];
            edges.get(item[1]).add(item[0]);
            ++indeg[item[0]];
        }

        //关键数据结构
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }

        int count=0;
        while(!queue.isEmpty()){
            int i = queue.poll();
            count++;
            List<Integer> cours = edges.get(i);
            for (Integer cour : cours) {
                --indeg[cour];
                if(indeg[cour] == 0){
                    queue.offer(cour);
                }
            }
        }

        return count == numCourses;
    }


}
