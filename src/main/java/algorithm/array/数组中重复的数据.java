package algorithm.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/9/19 10:14
 */
public class 数组中重复的数据 {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected = Arrays.asList(2, 3);
        new 数组中重复的数据().findDuplicates(nums);
    }
}
