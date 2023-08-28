package algorithm.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/8/24 11:11
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        // 按照起点排序
        Arrays.sort(intervals,(v1, v2) -> (v1[0]-v2[0]));
        List<int []> res = new ArrayList<>();
        int [] cur = intervals[0];
        for(int i =1;i<intervals.length;i++){
            if(cur[1]>=intervals[i][0]){
                cur[1] = Math.max(cur[1],intervals[i][1]);
            }else{
                res.add(cur);
                cur = intervals[i];
            }
        }
        // 处理最后一个区间
        res.add(cur);
        return res.toArray(new int[0][]);

    }
}
