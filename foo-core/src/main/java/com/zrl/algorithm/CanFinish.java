package com.zrl.algorithm;

import java.util.*;

/**
 * @Author riliang.zrl
 * @Date 2024/5/27 23:22
 * @Description
 **/
public class CanFinish {
    //edges的list下标为需要先修的课程， 值List<Integer>为依赖该先修课程的其他课程
    List<List<Integer>> edges;

    //数组下标表示课程id，值为需要先修的课程数量，再后面的逻辑中先修课程修完一颗，则减一直到0该门课程就可以修了
    //另外一种解释：数组下标表示课程id， 值表示入度
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }


}
