package algorithm.prefixsum;

/**
 * @author LongyunBian
 * @version 2023/8/19 21:25
 * @link https://leetcode.cn/problems/number-of-sub-arrays-with-odd-sum/description/
 */
public class 和为奇数的子数组数目 {
    public int numOfSubArrays(int[] arr) {
        int n = arr.length;
        int oddCount = 0, evenCount = 1;
        int prefixSum = 0, result = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if ((prefixSum & 1) == 0) {
                result = (result + oddCount)%1000000007;
                evenCount++;
            } else {
                result = (result + evenCount)%1000000007;
                oddCount++;
            }
        }

        return result;

    }
}
