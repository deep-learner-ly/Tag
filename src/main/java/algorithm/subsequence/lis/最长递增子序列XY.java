package algorithm.subsequence.lis;

import algorithm.subsequence.lis.最长递增子序列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/9/1 19:35
 */
public class 最长递增子序列XY {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int [][] things = new int[n][2];
            for (int j = 0; j < n; j++) {
                things[j][0] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                things[j][1] = in.nextInt();
            }
            System.out.println(new 最长递增子序列XY().maxThingNum(things));

        }
    }
    public int maxThingNum(int [][] things){
        Arrays.sort(things,(a,b)->a[0]-b[0]);
        int [] heights = new int[things.length];
        for (int i = 0; i < things.length; i++) {
            heights[i] = things[i][1];
        }
        return new 最长递增子序列().lengthOfLIS(heights);
    }

}
