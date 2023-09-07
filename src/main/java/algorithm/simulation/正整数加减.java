package algorithm.simulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/9/7 16:57、
 * @link https://www.nowcoder.com/exam/test/73289912/detail?pid=50570189&examPageSource=Company&testCallback=https%3A%2F%2Fwww.nowcoder.com%2Fexam%2Fcompany&testclass=%E8%BD%AF%E4%BB%B6%E5%BC%80%E5%8F%91
 */
public class 正整数加减 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt(),b = in.nextInt(),l = in.nextInt(),r = in.nextInt();
            helper(b-a,l,r);

        }


    }

    private static void helper(int target, int l, int r) {
        // 完全背包
        int [] dp1 = new int[target+1];
        Arrays.fill(dp1,Integer.MAX_VALUE);
        dp1[0] = 0;
        for(int i = l;i<=r;i++){
            for (int j = 0; j <= target; j++) {
                if(j>=i && dp1[j-i]!=Integer.MAX_VALUE){
                    dp1[j] = Math.min(dp1[j],dp1[j-i]+1);
                }

            }
        }
        int res1 = dp1[target];
        if(res1==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        Arrays.fill(dp1, Integer.MIN_VALUE);
        dp1[0] = 0;
        for(int i = l;i<=r;i++){
            for (int j = 0; j <= target; j++) {
                if(j>=i && dp1[j-i]!=Integer.MIN_VALUE){
                    dp1[j] =Math.max(dp1[j],dp1[j-i]+1);
                }
            }
        }
        System.out.println(res1+" "+dp1[target]);

    }
}
