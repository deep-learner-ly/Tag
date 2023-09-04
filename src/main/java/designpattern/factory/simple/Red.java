package designpattern.factory.simple;

/**
 * @author LongyunBian
 * @version 2023/9/4 10:24
 */
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
