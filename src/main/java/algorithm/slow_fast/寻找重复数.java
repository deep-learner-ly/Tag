package algorithm.slow_fast;


//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。


//比较简单的方案是按照快慢指针来做，技巧题
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        //之所以这两句没有在循环里面，是为了保证初始循环能正常进行
        slow=nums[slow];
        fast=nums[nums[fast]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
