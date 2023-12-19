package algorithm.array;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

import java.util.*;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res =new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int total=m*n;
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int index=0;

        boolean[][] visited=new boolean[m][n];
        int row=0;int col=0;
        for(int i=0;i<total;i++){
            res.add(matrix[row][col]);
            visited[row][col]=true;

            int newrow=row+dir[index][0];
            int newcol=col+dir[index][1];
            if(newrow<0||newrow>=m||newcol<0||newcol>=n||visited[newrow][newcol]){
                index=(index+1)%4;
            }
            row=row+dir[index][0];
            col=col+dir[index][1];
        }
        return res;
    }
    // 下面的方法，不需要额外的空间，
    public List<Integer> spiralOrderLy(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m-1,left =0, right = n-1;
        int total = m*n;
        List<Integer> res = new ArrayList<>(total);

        while(res.size()<total){
            // left to right
            for(int i=left;i<=right&&res.size()<total;i++)  res.add(matrix[top][i]);
            top++;
            // top to bottom
            for(int i = top;i<=bottom&&res.size()<total;i++) res.add(matrix[i][right]);
            right--;
            // right to left
            for(int i=right;i>=left&&res.size()<total;i--) res.add(matrix[bottom][i]);
            bottom--;
            // bottom to top
            for(int i=bottom;i>=top&&res.size()<total;i--) res.add(matrix[i][left]);
            left++;
        }
        return res;


    }
}

