package algorithm.bag.bag01;

import java.util.Arrays;

/**
 * @author LongyunBian
 * @version 2023/8/28 23:44
 */
public class 最少数字 {
    /*
    * 小明用计算机随机生成了N个正整数，他希望从这N个数中选取若千个数，使得它们的和等于M。
    * 这些随机生成的数字可能会相同，但是每个数字最多只允许使用一次。当然这样的选取方案可
    * 能不存在，也可能有多个。现在希望你编写一个程序，能够找出数字个数最少的选取方案，输
    * 出对应的最少数字的个数，如果无解输出“No solution”。
    * */
    public static void main(String[] args) {
        System.out.println(new 最少数字().minNumbers(new int[]{1, 3, 2, 1, 1}, 5));
    }
    public int minNumbers(int [] nums, int target){
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int num : nums) {
            for (int j = target; j >=num; j--) {
                if(dp[j-num]!=Integer.MAX_VALUE){
                    dp[j] = Math.min (dp[j],dp[j-num]+1);
                }
            }
        }

        return dp[target];
    }
}
