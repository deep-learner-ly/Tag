package algorithm.interval;

import algorithm.subsequence.最长递增子序列;

import java.util.Arrays;

/**
 * @author LongyunBian
 * @version 2023/8/24 11:59
 */
public class 俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        int [][] envs = {{5,4},{6,4},{6,7},{2,3},{7,8}};
        System.out.println(new 俄罗斯套娃信封问题().maxEnvelopes(envs));
    }
    public int maxEnvelopes(int[][] envelopes) {
        // 第一个位置升序，第二个位置降序
        Arrays.sort(envelopes,(v1,v2)-> v1[0]==v2[0]?v2[1]-v1[1]:v1[0]-v2[0]);
        int [] nums = new int[envelopes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }
        return new 最长递增子序列().lengthOfLIS(nums);
    }
}
