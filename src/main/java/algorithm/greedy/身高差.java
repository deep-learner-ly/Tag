package algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/8/28 22:49
 */
public class 身高差 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }

        System.out.println(new 身高差().maxDiff(heights));

    }
    public int maxDiff(int [] heights){
        Arrays.sort(heights);
        int n = heights.length;

        int[] ans = new int[n];
        boolean flag = true;
        int left = 0, right = n - 1;

        for (int i = 0; i < n; i++) {
            if (flag) {
                ans[left++] = heights[i];
            } else {
                ans[right--] = heights[i];
            }
            System.out.println(flag);
            flag = !flag;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, Math.abs(ans[i] - ans[(i + 1) % n]));
        }
        return max;
    }
}
