package algorithm.interval;

import java.util.Arrays;

/**
 * @author LongyunBian
 * @version 2023/8/24 11:42
 */
public class 删除被覆盖区间 {
    public int removeCoveredIntervals(int[][] intervals) {
        // 左端点升序，右端点降序
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0, range = 0;
        for (int i = 0; i < intervals.length; i++) {

            int b = intervals[i][1];
            if (b > range) {
                ans += 1;
                range = b;
            }
        }
        return ans;


    }
}
