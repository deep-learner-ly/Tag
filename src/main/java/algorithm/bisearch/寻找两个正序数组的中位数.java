package algorithm.bisearch;

//题目：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//算法的时间复杂度应该为 O(log (m+n)) 。二分法

public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int total=m+n;
        //如果A数组长度+B数组长度total是奇数，则找total/2+1小的元素即为中位数
        if(total%2==1){
            int midIndex = total/2+1;
            return getKth(nums1,nums2,midIndex);
        }else{ //否则，找total/2，total/2+1这两个元素
            double a=getKth(nums1,nums2,total/2);
            double b=getKth(nums1,nums2,total/2+1);
            return (a+b)/2.0;
        }
    }

    public int getKth(int[] nums1,int[] nums2,int k){
        int len1=nums1.length;
        int len2=nums2.length;
        int index1=0;
        int index2=0;
        while(true){
            //边界情况，当index1越界时，直接返回nums2的第k小元素
            if(index1==len1) return nums2[index2+k-1];
            //边界情况，当index2越界时，直接返回nums1的第k小元素
            if(index2==len2) return nums1[index1+k-1];
            //边界情况，k等于1时，返回nums1第一个元素和nums2第一个元素较小者
            if(k==1) return Math.min(nums1[index1],nums2[index2]);

            int half=k/2;
            int newIndex1=Math.min(index1+half,len1)-1;
            int newIndex2=Math.min(index2+half,len2)-1;
            int pivot1=nums1[newIndex1];
            int pivot2=nums2[newIndex2];
            if(pivot1<pivot2){
                k=k-(newIndex1-index1+1);
                index1=newIndex1+1;
            }else{
                k=k-(newIndex2-index2+1);
                index2=newIndex2+=1;
            }
        }
    }

}
