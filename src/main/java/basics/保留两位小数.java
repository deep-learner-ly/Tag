package basics;

import java.text.DecimalFormat;

/**
 * @author LongyunBian
 * @version 2023/9/9 17:36
 */
public class 保留两位小数 {
    public static void main(String[] args) {
        double one = 7.26500;
        String  str = String.format("%.2f",one);
        System.out.println(str);

    }
}
