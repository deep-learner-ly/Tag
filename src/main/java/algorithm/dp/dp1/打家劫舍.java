package algorithm.dp.dp1;

/**
 * @author LongyunBian
 * @version 2023/9/12 17:54
 */
public class 打家劫舍 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // 使用两个变量来维护前两个最大值
        int prevMax = nums[0];
        int currMax = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }

        return currMax;
    }

}
