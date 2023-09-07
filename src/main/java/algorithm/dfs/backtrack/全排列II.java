package algorithm.dfs.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/9/7 16:36
 */
public class 全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        // 存储最终的全排列结果
        List<List<Integer>> res = new ArrayList<>();
        // 记录元素是否被访问过
        boolean [] visited =new boolean [nums.length];
        // 回溯生成全排列
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, boolean[] visited) {
        // 如果当前排列长度等于数组长度，表示已经生成了一个全排列，将其添加到结果集中
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // 遍历数组中的每个元素
        for (int i = 0; i < nums.length; i++) {
            // 如果元素已经被访问过，则跳过该元素
            if (visited[i]) continue;
            if(i>0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
            // 标记当前元素为已访问
            visited[i] = true;
            // 将当前元素加入到排列中
            tmp.add(nums[i]);
            // 递归生成下一个位置的排列
            backtrack(res, nums, tmp, visited);
            // 回溯，撤销选择，将当前元素从排列中移除，并标记为未访问
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
