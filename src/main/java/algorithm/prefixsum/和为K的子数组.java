package algorithm.prefixsum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Callable;

/**
 * @author LongyunBian
 * @version 2023/8/19 17:36
 * @link https://leetcode.cn/problems/subarray-sum-equals-k/description/
 */
public class 和为K的子数组 {

//    public static void main(String[] args) {
//        new 和为K的子数组().subarraySum(new int[]{1, -1, 0},0);
//    }
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;


    }
}
