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
}

