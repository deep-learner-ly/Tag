package algorithm.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LongyunBian
 * @version 2023/10/17 15:37
 */
public class 腐烂橘子 {
    public int orangesRotting(int[][] grid) {
        Queue<int []>  queue = new LinkedList<>();
        int count = 0;
        int ans =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    count++;
                }
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(count==0){
            return ans;
        }

        int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int [] point = queue.poll();
                for (int[] direction : directions) {
                    int x = point[0]+direction[0];
                    int y = point[1]+direction[1];
                    if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1){
                        grid[x][y]=2;
                        queue.offer(new int[]{x,y});
                        count--;

                    }
                }
            }
            ans++;
            if(count==0){
                return ans;
            }
        }
        return -1;



    }
}
