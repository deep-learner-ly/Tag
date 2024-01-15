package algorithm.bfs;

//题目：你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
//在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//
//例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。


//如：输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。


import java.util.*;
public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int cur=pre[1];
            int next=pre[0];
            indegree[next]++;
            adj.get(cur).add(next);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int now = stack.poll();
            numCourses--;
            for(int cur:adj.get(now)){
                if(--indegree[cur]==0){
                    stack.push(cur);
                }
            }
        }
        return numCourses==0;
    }
}
