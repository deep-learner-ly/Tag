package algorithm.interval;

import java.util.Arrays;

/**
 * @author LongyunBian
 * @version 2023/9/4 17:47
 */
public class 无重叠区间 {
    public static void main(String[] args) {
        int [][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        new 无重叠区间().eraseOverlapIntervals(intervals);

    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(v1,v2)->(v1[1]-v2[1]));
        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

}
