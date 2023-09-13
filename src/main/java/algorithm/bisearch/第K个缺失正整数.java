package algorithm.bisearch;

/**
 * @author LongyunBian
 * @version 2023/9/13 23:57
 */
public class 第K个缺失正整数 {
    public int findKthPositive(int[] arr, int k) { // 二分
        int l = 0,r = arr.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if( arr[mid]-mid-1 < k){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l+k;
    }
    public int findKthPositiveN(int[] arr, int k) {
        int current =1, count = 0, idx =0;
        while(count<k){
            if(arr[idx]==current){
                if(idx<arr.length-1){
                    ++idx;
                }

            }else {
                count++;
            }
            current++;

        }
        return current-1;

    }
}
