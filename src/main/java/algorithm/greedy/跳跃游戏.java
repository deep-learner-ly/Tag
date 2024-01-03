package algorithm.greedy;

//题目：给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//        判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
//如输入：nums = [2,3,1,1,4]  输出：true


public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(i<=k){
                k=Math.max(k,i+nums[i]);
            }
            if(k>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
