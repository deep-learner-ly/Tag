package algorithm.bisearch;

/**
 * @author LongyunBian
 * @version 2023/8/24 15:11
 */
public class 二分查找第一个位置和最后一个位置 {
    private int bSearchLeft(int[] nums, int target){
        int l = 0,r = nums.length-1;

        while(l<r){
            int mid = (l+r) >>1 ;
            if(nums[mid]<target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return nums[l]==target?l:-1;
    }
    private int bSearchRight(int[] nums, int target){
        int l = 0,r = nums.length-1;

        while(l<r){
            int mid = (l+r+1) >>1 ;
            if(nums[mid]>target){
                r = mid-1;
            }else{
                l = mid;
            }
        }
        return nums[l]==target?l:-1;
    }
}
