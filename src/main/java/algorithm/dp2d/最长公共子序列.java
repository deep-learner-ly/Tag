package algorithm.dp2d;

/**
 * @author LongyunBian
 * @version 2023/8/19 21:44
 * @link https://leetcode.cn/problems/longest-common-subsequence/description/
 */
public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int [][] dp = new int[n1+1][n2+1];
        for (int i = 1; i <= n1; i++) {
            char c1 = text1.charAt(i-1);

            for (int j = 1; j <= n2; j++) {
                if(text2.charAt(j-1)==c1){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];

    }
}
