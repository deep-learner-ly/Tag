package algorithm.array;

import java.util.*;

/**
 * @author LongyunBian
 * @version 2023/8/19 22:16
 * @link https://52heartz.top/articles/algorithm-find-elements-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater/
 */
public class 数组中比左边大比右边的小的元素 {
    public static void main(String[] args) {
        int[] elements = new 数组中比左边大比右边的小的元素().findElements(new int[]{1,2,3,1,4,5,5,6});
        for (int element : elements) {
            System.out.println(element);
        }
    }
    public int[] findElements(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                set.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; --i) {
            if(nums[i]<min){
                min = nums[i];
            }else if(set.contains(i)){
                set.remove(i);
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int i : set) {
            res[index++] = nums[i];
        }

        return res;
    }
}
