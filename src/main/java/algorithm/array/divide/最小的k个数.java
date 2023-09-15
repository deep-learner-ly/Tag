package algorithm.array.divide;

/**
 * @author LongyunBian
 * @version 2023/9/15 16:09
 */
public class 最小的k个数 {
    public static void main(String[] args) {
        int [] arr ={3,2,1};
        int k = 2;
        new 最小的k个数().getLeastNumbers(arr,k);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[]{};
        }
        quickSelect(arr,0,arr.length-1,k);
        int [] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private void quickSelect(int[] arr, int lo, int hi, int k) {
        int idx = 快速排序.partition(arr,lo,hi);
        if(idx==k-1){

        }else if(idx<k-1){
            quickSelect(arr,idx+1,hi,k);
        }else {
            quickSelect(arr,lo,idx-1,k);
        }
    }

}
