package algorithm.window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author LongyunBian
 * @version 2023/8/31 16:51
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int [] nums = {9,3,-1,-3,5,3,6,7};
        int  k = 3;
        int[] ints = new 滑动窗口最大值().maxSlidingWindow(nums, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 双端队列
        // 时间复杂度： O(n)
        // 空间复杂度： O(n)
        Deque<Integer> d = new ArrayDeque<>();
        int n = nums.length, m = n - k + 1;
        int[] ans = new int[m];
        for (int i = 0; i < n; i++) {
            // 从last出发把小于等于cur的弹出，因为它们比不可能是ans
            while (!d.isEmpty() && nums[d.peekLast()] <= nums[i]) d.pollLast();
            // 保持从last 到 first是递增的
            d.addLast(i);
            if (i >= k - 1) {
                // 取结果时，要判断first是否在窗口内，不在窗口内就弹出
                while (!d.isEmpty() && d.peekFirst() <= i - k) d.pollFirst();
                // first是最大值，收集结果
                ans[i - k + 1] = nums[d.peekFirst()];
            }
        }
        return ans;
    }


}
