package algorithm.bfs;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/9/21 9:30
 */
public class 快速穿球 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int [][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = in.nextInt();
            }
        }
        int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int []> queue = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if(mat[i][0]==1){
                queue.offer(new int[]{i,0});
                boolean [][] used = new boolean[m][n];
                used[i][0] = true;
                int distance = 0;
                while (!queue.isEmpty()){
                    int size = queue.size();
                    while (size>0){
                        int [] a = queue.poll();
                        int x = a[0], y = a[1];
                        if(y==n-1){
                            res = Math.min(res,distance);
                        }
                        for(int [] dir :dirs){
                            int nx = x+dir[0];
                            int ny = y+dir[1];
                            if(distance==0&&ny==0) continue;
                            if(nx>=0&&nx<m&&ny>=0&&ny<n&&!used[nx][ny]&&mat[nx][ny]==1){
                                queue.offer(new int[]{nx,ny});
                                used[nx][ny] = true;
                            }
                        }

                        size--;
                    }
                    distance++;
                }
            }
        }
        if(res!=Integer.MAX_VALUE){
            System.out.println(res);
        }else {
            System.out.println(-1);
        }

    }
}
