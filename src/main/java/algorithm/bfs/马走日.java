package algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author LongyunBian
 * @version 2023/8/19 11:20
 * @link https://www.lintcode.com/problem/3682/description?_from=problem_tag&fromId=391
 */
public class 马走日 {
    /**
     * @param x: The x-coordinate of the endpoint
     * @param y: The y-coordinate of the endpoint
     * @return The shortest path
     */
    public int shortestPath(int x, int y) {
        // write your code here
        x += 310;
        y += 310;
        int res = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {310, 310});
        boolean[][] vis = new boolean[700][700];
        vis[310][310] = true;
        int[][] directions = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; --k) {
                int[] point = q.poll();
                if (point[0] == x && point[1] == y) {
                    return res;
                }
                for (int[] dir : directions) {
                    int new_x = point[0] + dir[0];
                    int new_y = point[1] + dir[1];
                    if (!vis[new_x][new_y]) {
                        vis[new_x][new_y] = true;
                        q.offer(new int[] {new_x, new_y});
                    }
                }
            }
            ++res;
        }
        return -1;
    }

}
