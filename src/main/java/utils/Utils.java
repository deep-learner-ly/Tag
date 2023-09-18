package utils;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/8/19 16:20
 */
public class Utils {
    public static void reverseArray(int []array){
        int i=0,j=array.length-1;
        while (i<j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            ++i;
            --j;
        }
    }
    public static int strStr(String str, String target,int start){
        //构建长度与needle相等的滑动窗口
        int left = start, right = start +  target.length();
        //不断移动滑动窗口，窗口的子串与目标子串进行匹配
        while (right <= str.length() ) {
            if (str.substring(left, right).equals(target)) return left;
            left++;
            right++;
        }
        return -1;
    }
    public static void swap(int [] nums,int i,int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
    public static void swap(Object [] objects,int i,int j){
        Object temp = objects[i];
        objects[i] = objects[j];
        objects[j] = temp;
    }
    public static void swapPlusSub(int [] nums,int i,int j){
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] -nums[j];
        nums[i] = nums[i] -nums[j];
    }
    private static ListNode reverse(ListNode head){ // 反转链表
        ListNode newHead = null;
        while (head!=null){
            ListNode nxt = head.next;
            head.next = newHead;
            newHead = head;
            head = nxt;
        }
        return newHead;
    }
    public static int[][] transpose(int[][] matrix) { // 矩阵转置
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] t = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[j][i] = matrix[i][j];

            }
        }
        return t;
    }
    public static void transposeInPlace(int [][] matrix){ // n*n 矩阵原地转置
        assert matrix.length == matrix[0].length;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
    public double pow(double x, int n){ // 快速幂
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n==Integer.MIN_VALUE){
            return 1/(x*pow(x,Integer.MAX_VALUE));
        }
        if(n<0){
            return 1/pow(x,-n);
        }
        double temp = pow(x,n/2);
        return n%2==0? temp*temp:temp*temp*x;
    }
    public static int [][] matrixPow(int [][] mat,int n){ // 矩阵快速幂
        assert n>0;
        if(n==1){
            return mat;
        }
        int [][] temp = matrixPow(mat,n/2);
        return n%2==0?matrixMultiply(temp,temp):matrixMultiply(matrixMultiply(temp,temp),mat);
    }
    public static int [][] matrixMultiply(int [][] mat1 ,int [][] mat2 ){ // 矩阵乘法
        int m = mat1.length;
        int n = mat2[0].length;
        int [][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }

}
