package algorithm.dp.dp1;

import java.util.Arrays;

/**
 * @author LongyunBian
 * @version 2023/9/1 21:33
 */
public class 不同二叉树的个数 {
    /**
     *  n个节点， 树高不超过m 的二叉树个数
     */
    private static final int MOD = (int) (1e9+7);
    private long numOfBiTree(int n,int m){
        long [][] dp = new  long[n+1][m+1];
        Arrays.fill(dp[0],1);
        for(int i=1;i<=n;i++) {//结点数
            for (int j = 1; j <= m; j++) {
                for(int k=0;k<i;k++){
                    // 左子树节点个数k,右子树节点个数i-k-1
                    dp[i][j] = (dp[i][j] + dp[k][j-1] * dp[i-k-1][j-1] % MOD)%MOD;
                }
            }
        }
        return dp[n][m];

    }
}
