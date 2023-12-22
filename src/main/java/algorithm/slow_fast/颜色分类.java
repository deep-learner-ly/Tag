package algorithm.slow_fast;

//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//        我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//        必须在不使用库内置的 sort 函数的情况下解决这个问题。



//快慢指针用处广泛，怎么样设计是关键
public class 颜色分类 {
    public void sortColors(int[] nums) {
        int slow=0;
        int fast=0;

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            nums[i]=2;
            if(num<2){
                nums[fast++]=1;
            }
            if(num<1){
                nums[slow++]=0;
            }
        }
    }
}
