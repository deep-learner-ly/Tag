package algorithm.topologicalsort;

import utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LongyunBian
 * @version 2023/8/29 7:58
 */
public class 课程表 {
    List<List<Integer>> edges1;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS
        edges1 = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i) {
            edges1.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges1.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges1.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }


    List<List<Integer>> edges2;
    int[] visited;
    boolean valid = true;
    int [] res;
    int idx;

    public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        edges2 = new ArrayList<List<Integer>>();
        res = new int[numCourses];
        idx = 0;
        for (int i = 0; i < numCourses; ++i) {
            edges2.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges2.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        return valid;
    }

    public void dfs(int u) {
        //标记为搜索中
        visited[u] = 1;
        for (int v: edges2.get(u)) {
            //如果指向的某一学科未搜索过，则深搜
            if (visited[v] == 0) {
                dfs(v);
            } else if (visited[v] == 1) {
                // 如果指向的某一学科在搜索中，则有环
                valid = false;
                return;
            }
        }
        //标记为已完成
        visited[u] = 2;
    }

}
