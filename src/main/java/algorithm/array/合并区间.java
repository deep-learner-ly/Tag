package algorithm.array;


//题目：以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间

import java.util.*;
import java.util.Comparator;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] interval1,int[] interval2){
                return interval1[0]-interval2[0];
            }
        });
        // Lambda表达式优化 ly
        // Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int left=intervals[i][0];
            int right=intervals[i][1];
            if(res.size()==0||res.get(res.size()-1)[1]<left){
                res.add(new int[]{left,right});
            }else{
                res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],right);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}


//通过创建一个匿名内部类实现了Comparator接口，并重写了compare()方法来定义排序规则。compare()方法的参数是两个int类型的数组interval1和interval2，它们分别表示待比较的两个元素。
//
//在compare()方法中，通过比较interval1[0]和interval2[0]的值，返回它们的差值。如果差值为正数，则表示interval1的第一个元素大于interval2的第一个元素，
// 需要将interval1放在interval2之后；如果差值为负数，则表示interval1的第一个元素小于interval2的第一个元素，需要将interval1放在interval2之前；如果差值为0，则表示interval1的第一个元素等于interval2的第一个元素，它们的顺序保持不变。
//
//通过使用这个Comparator对象作为sort()方法的参数，就可以根据interval1[0]的值对数组intervals进行排序。排序后，intervals数组中的元素按照interval1[0]的升序排列。
// 最后，使用res.toArray方法将ArrayList转换为二维数组，并返回合并后的结果。