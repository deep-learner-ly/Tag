package algorithm.subsequence;

/**
 * @author LongyunBian
 * @version 2023/8/24 12:11
 */
public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int len =1;
        int n = nums.length;
        int [] d = new int[n+1];
        d[len] = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>d[len]){
                d[++len] = nums[i];
            }else{
                int l = 1, r =len;
                while(l<=r){
                    int mid = (l+r) >> 1;
                    if(d[mid]<nums[i]){
                        l  = mid +1;
                    }else{
                        r = mid -1;
                    }
                }
                d[l] = nums[i];
            }
        }
        return len;

    }
}
