package algorithm.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/8/24 11:54
 */
public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {

        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            ret.add(temp.toString());
        }
        return ret;

    }
}
