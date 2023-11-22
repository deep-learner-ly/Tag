package algorithm.array.divide;

import java.util.HashMap;

/**
 * @author LongyunBian
 * @version 2023/11/13 9:50
 */
public class 前k个高频 {
    public static void main(String[] args) {
        int [] nums = {2,2,3,1,1,1};
        int k =2;
        new 前k个高频().topKFrequent(nums,k);
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        int [][] array = new int[map.size()][2];
        int index = 0;
        for(int key:map.keySet()){
            array[index][0] =key;
            array[index][1] = map.get(key);
            index++;
        }
        qSelect(array, 0, array.length - 1, array.length - k);
        int [] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = array[array.length - k+i][0];
        }

        return  res;


    }
    public int[] qSelect(int[][] nums, int lo, int hi, int k){
        int idx = partition(nums,lo,hi);
        if(idx==k){
            return nums[idx];
        }else if(idx>k){
            return qSelect(nums,lo,idx-1,k);
        }else {
            return qSelect(nums,idx+1,hi,k);
        }

    }
    public  int partition(int [][] nums, int lo, int hi) {
        int[] pivot = nums[lo];
        while(lo<hi){
            while(lo<hi && nums[hi][1]>=pivot[1] ) hi--;
            nums[lo] = nums[hi];
            while (lo<hi && nums[lo][1]<=pivot[1] ) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}
