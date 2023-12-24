package algorithm.bag.bag01;

//问题：给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。


//太难了，看了半天才大概明白，0-1背包问题
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        if(nums.length==1) return false;
        int sum=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int target=sum/2;
        if(sum%2!=0||target<max) return false;

        int[] dp=new int[target+1];
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            for(int j=target;j>=num;j--){
                dp[j]=Math.max(dp[j],dp[j-num]+num);
                if(dp[target]==target) return true;
            }
        }
        return dp[target]==target;

    }
}
