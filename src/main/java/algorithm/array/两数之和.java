package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LongyunBian
 * @version 2023/9/18 9:39
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
