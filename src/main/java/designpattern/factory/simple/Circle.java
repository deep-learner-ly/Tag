package designpattern.factory.simple;

/**
 * @author LongyunBian
 * @version 2023/9/4 10:23
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
