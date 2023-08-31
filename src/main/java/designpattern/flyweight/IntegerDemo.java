package designpattern.flyweight;

/**
 * @author LongyunBian
 * @version 2023/8/31 16:05
 */
public class IntegerDemo {
    public static void main(String[] args) {
        Integer i1 = 56;
        Integer i2 = 56;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));
    }
}
