package algorithm.bag.bagcomplete;

import java.util.Arrays;

/**
 * @author LongyunBian
 * @version 2023/8/28 23:54
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int [amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int coin:coins){
            for(int i=1;i<=amount;i++){
                if(i>=coin && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];

    }
}
