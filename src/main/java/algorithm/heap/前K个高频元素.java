package algorithm.heap;

import java.util.*;

/**
 * @author LongyunBian
 * @version 2023/8/21 22:30
 * @link https://leetcode.cn/problems/top-k-frequent-elements/description/
 */
public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        // n log k
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, value) -> (value == null) ? 1 : value + 1);
        }
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        int i =0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(i<k){
                minHeap.offer(new int[]{entry.getKey(),entry.getValue()});
            }else{
                if(entry.getValue()> minHeap.peek()[1]){
                    minHeap.poll();
                    minHeap.offer(new int[]{entry.getKey(),entry.getValue()});
                }
            }
            i++;
        }
        int[] ans = new int[k];
        for (int j = 0; j < k; ++j) ans[j] = minHeap.poll()[0];
        return ans;
    }
    public int[] topKFreq(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, value) -> (value == null) ? 1 : value + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        // 使用 Collections.sort() 对列表进行排序
        Collections.sort(entryList, Map.Entry.comparingByValue());
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = entryList.get(i+entryList.size()-k).getKey();
        }

        return res;

    }
}
