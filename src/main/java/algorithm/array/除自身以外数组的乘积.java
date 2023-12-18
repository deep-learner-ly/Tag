package algorithm.array;
//题目：给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res=new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=nums[i-1]*res[i-1];
        }
        int R=1;
        for(int i=n-1;i>=0;i--){
            res[i]=res[i]*R;
            R=R*nums[i];
        }
        return res;

    }
}


//想不到还能这样写，想到之后还是挺简单的，继续加油