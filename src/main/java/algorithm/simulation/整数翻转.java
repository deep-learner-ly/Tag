package algorithm.simulation;

import java.util.Scanner;

/**
 * @author LongyunBian
 * @version 2023/9/7 10:16
 */
public class 整数翻转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int k = in.nextInt();
        String s = String.valueOf(x);
        String s1 = s.substring(0,k);
        String s2 = s.substring(k);

        StringBuilder sb = new StringBuilder(s1);
        s1 = sb.reverse().toString();
        int idx =0;
        while(s1.charAt(idx)=='0') idx++;
        s1 = s1.substring(idx);
        System.out.println(s1+s2);
    }
}
