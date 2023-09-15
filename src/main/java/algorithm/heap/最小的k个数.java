package algorithm.heap;

import java.util.PriorityQueue;

/**
 * @author LongyunBian
 * @version 2023/9/15 16:01
 */
public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        for (int i = 0; i < arr.length; i++) {
            if(i<k){
                maxHeap.offer(arr[i]);
            }else {
                if(arr[i]<maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }
        int [] ans = new int[k];
        int i =0 ;
        for (Integer integer : maxHeap) {
            ans[i++]  = integer;
        }
        return ans;


    }

}
