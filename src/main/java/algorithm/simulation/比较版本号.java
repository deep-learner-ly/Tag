package algorithm.simulation;

import java.util.Arrays;

/**
 * @author LongyunBian
 * @version 2023/9/26 16:50
 */
public class 比较版本号 {
    public int compareVersion(String version1, String version2) {
        // 按照点分割字符串
        int[] array1 = Arrays.stream(version1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(version2.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int i = 0, j=0;
        for ( ;i < array1.length&&j<array2.length;j++, i++) {
            if(array1[i]<array2[j]){
                return -1;
            } else if (array1[i]>array2[j]) {
                return 1;
            }
        }
        while(i<array1.length){
            if(array1[i++]!=0){
                return 1;
            }
        }
        while(j<array2.length){
            if(array2[j++]!=0){
                return -1;
            }
        }
        return 0;
    }
    public int compareVersionBest(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();

        int i = 0;
        int j = 0;
        while(i < m || j < n) {
            int x = 0;
            for(; i < m && version1.charAt(i) != '.'; i++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++;
            int y = 0;
            for(; j < n && version2.charAt(j) != '.'; j++) {
                y = y * 10 + version2.charAt(j) -'0';
            }
            j++;
            if(x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new 比较版本号().compareVersion("1","2");
    }
}
