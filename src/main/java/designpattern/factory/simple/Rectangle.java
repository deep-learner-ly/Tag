package designpattern.factory.simple;

/**
 * @author LongyunBian
 * @version 2023/9/4 10:22
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
