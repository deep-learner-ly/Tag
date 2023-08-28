package algorithm.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/8/24 11:19
 */
public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        // 判断左边不重合
        while(i<len && intervals[i][1]<newInterval[0]) res.add(intervals[i++]);

        // 判断重合
        while(i<len && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // 判断右边不重合
        while(i<len ){
            res.add(intervals[i++]);
        }

        return res.toArray(new int[0][]);
    }

}
