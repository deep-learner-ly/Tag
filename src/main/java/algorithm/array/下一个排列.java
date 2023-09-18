package algorithm.array;

/**
 * @author LongyunBian
 * @version 2023/9/18 15:45
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        int i = nums.length -2 ;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j = nums.length -1;
            while(j>=i+1 && nums[j]<= nums[i]) j--;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        reverse(nums, i+1);
    }
    private void reverse(int [] nums, int start){
        for(int i=start,j =nums.length-1;i<j;i++,j--){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
