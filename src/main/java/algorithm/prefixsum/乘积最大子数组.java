package algorithm.prefixsum;

/**
 * @author LongyunBian
 * @version 2023/8/19 14:45
 * @link https://leetcode.cn/problems/maximum-product-subarray/description/
 */
public class 乘积最大子数组 {
    /**
     * 以下标 i 结尾的连续子序列的乘积的最大值
     * */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int maxF = nums[0];
        int minF = nums[0];

        int ans = maxF;
        for (int i = 1; i < length; ++i) {
            int newMaxF = Math.max(maxF * nums[i], Math.max(nums[i], minF * nums[i]));
            int newMinF = Math.min(minF * nums[i], Math.min(nums[i], maxF * nums[i]));
            maxF = newMaxF;
            minF = newMinF;
            ans = Math.max(maxF,ans);
        }

        return ans;
    }
}
