package algorithm.greedy;

//题目：给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//0 <= j <= nums[i]，i + j < n
//返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

//如输入: nums = [2,3,1,1,4]，输出: 2

public class 跳跃游戏II {
    public int jump(int[] nums) {
        int end=0;
        int res=0;
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            max=Math.max(max,i+nums[i]);
            if(i==end){
                end=max;
                res++;
            }
        }
        return res;
    }
}
