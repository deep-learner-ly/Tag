package algorithm.prefixsum;

/**
 * @author LongyunBian
 * @version 2023/8/19 15:48
 */
public class 环形子数组的最大和 {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);

            totalSum += nums[i];
        }

        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;

    }
}
