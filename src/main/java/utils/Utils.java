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
}
