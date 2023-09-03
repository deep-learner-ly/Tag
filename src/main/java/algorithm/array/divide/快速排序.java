package algorithm.array.divide;

/**
 * @author LongyunBian
 * @version 2023/9/1 16:28
 */
public class 快速排序 {
    public static void main(String[] args) {
        int [] nums = {1,7,4,5,8,2,2};
        new 快速排序().qSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public void qSort(int [] nums){
        qSort(nums,0,nums.length-1);
    }

    private void qSort(int[] nums, int lo, int hi) {
        if(lo>=hi){
            return;
        }
        int idx = partition(nums,lo,hi);
        qSort(nums,lo,idx-1);
        qSort(nums,idx+1,hi);
    }

    public static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while(lo<hi){
            while(lo<hi && nums[hi]>= pivot) hi--;
            nums[lo] = nums[hi];
            while (lo<hi && nums[lo]<=pivot) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}
