package algorithm.bisearch;

/**
 * @author LongyunBian
 * @version 2023/8/24 15:06
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(new 搜索插入位置().searchInsert(new int[]{1, 3, 3, 3, 4}, 3));
    }
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1 ;
        while(low<high){
            int mid = low + (high - low)/2;

            if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid;
            }

        }
        return low;

    }
}
