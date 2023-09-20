package algorithm.bisearch;

/**
 * @author LongyunBian
 * @version 2023/9/20 22:35
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid+1]) { // 爬坡法
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;

    }
}
