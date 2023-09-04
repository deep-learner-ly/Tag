package algorithm.dp.dp1;

/**
 * @author LongyunBian
 * @version 2023/9/4 20:04
 */
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] -min;
            }
        }
        return max;

    }
}
