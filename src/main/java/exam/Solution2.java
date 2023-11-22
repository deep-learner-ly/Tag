package exam;

/**
 * @author LongyunBian
 * @version 2023/10/19 11:19
 */
public class Solution2 {
    /**
    *
     * 给定一个排序数组，你需要在原地（原数组）删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组。
     *
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * class Solution {
     *     public int removeDuplicates(int[] nums) {
     *
     *     }
     * }
    *
    */
    public int removeDuplicates(int[] nums) {
        int min = nums[0]-1;
        int count = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==cur) {
                nums[i] = min;
                count++;
            }else{
                cur = nums[i];
            }
        }
        int res = nums.length-count;
        int index =0;
        for (int i = 0; i < res;) {
            if(nums[index]!=min &&i<=index) {
                nums[i++] = nums[index];
            }
            index++;
        }
        return res;

     }

    public static void main(String[] args) {
        int [] nums = {1,1,2,2,3,4,4,4,4,6};
        int len = new Solution2().removeDuplicates(nums);
        System.out.println(len);
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }


}