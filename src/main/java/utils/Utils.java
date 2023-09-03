package utils;

/**
 * @author LongyunBian
 * @version 2023/8/19 16:20
 */
public class Utils {
    public static void reverseArray(int []array){
        int i=0,j=array.length-1;
        while (i<j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            ++i;
            --j;
        }
    }
    public static int strStr(String str, String target,int start){
        //构建长度与needle相等的滑动窗口
        int left = start, right = start +  target.length();
        //不断移动滑动窗口，窗口的子串与目标子串进行匹配
        while (right <= str.length() ) {
            if (str.substring(left, right).equals(target)) return left;
            left++;
            right++;
        }
        return -1;
    }
}
