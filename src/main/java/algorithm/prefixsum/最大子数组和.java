package algorithm.prefixsum;

/**
 * @author LongyunBian
 * @version 2023/8/19 14:48
 */
public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        // dp[i]：表示以 nums[i] 结尾 的 连续 子数组的最大和
        // int [] dp = new int [nums.length];
        int dp = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp>0){
                dp = nums[i] + dp;
            }else{
                dp = nums[i];
            }
            max = Math.max(max,dp);
        }
        return max;

    }
}
