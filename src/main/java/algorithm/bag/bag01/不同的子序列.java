package algorithm.bag.bag01;

/**
 * @author LongyunBian
 * @version 2023/9/20 21:28
 */
public class 不同的子序列 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m +1];
        dp[m] = 1;
        for (int i = n -1; i >= 0; i--){
            for (int j = 0; j < m; j++){
                if (t.charAt(j) == s.charAt(i)){
                    dp[j] += dp[j+1];
                }
            }
        }
        return dp[0];

    }
    public int numDistinct2D(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
//        ### 01 背包问题：
//
//        如果是 01 背包，即数组中的元素不可重复使用，外循环遍历 arrs，内循环遍历 target
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];

    }

}
