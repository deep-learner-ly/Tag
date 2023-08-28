package algorithm.bisearch;

/**
 * @author LongyunBian
 * @version 2023/8/24 16:06
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int low =0, high = nums.length -1;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                //前半部分有序
                if(nums[low]<=target && target<nums[mid]){
                    high = mid -1;
                }else{
                    low = mid+1;
                }
            }else{
                //后半部分有序
                if(nums[mid]<target && target<=nums[nums.length-1]){
                    low = mid+1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;


    }
}
