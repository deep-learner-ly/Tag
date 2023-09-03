package algorithm.array.divide;

/**
 * @author LongyunBian
 * @version 2023/9/1 16:28
 */
public class 第k大数 {
    public static void main(String[] args) {
        int [] nums = {1,7,4,5,8,2,2};
        System.out.println(new 第k大数().MaxKth(nums, 5));
    }
    int targetIdx;
    private int MaxKth(int [] nums,int k){
        targetIdx = nums.length - k;
        return qSelect(nums,0,nums.length-1);

    }

    private int qSelect(int[] nums, int lo, int hi) {
        int idx = 快速排序.partition(nums,lo,hi);
        if(idx==targetIdx){
            return nums[idx];
        }else if(idx>targetIdx){
            return qSelect(nums,lo,idx-1);
        }else {
            return qSelect(nums,idx+1,hi);
        }

    }
}
