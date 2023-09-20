package algorithm.array;

import utils.Utils;

/**
 * @author LongyunBian
 * @version 2023/9/19 17:02
 */
public class 缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                Utils.swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;


    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, -1, 1};
        System.out.println(new 缺失的第一个正数().firstMissingPositive(nums1));

    }

}
