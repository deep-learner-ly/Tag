package designpattern.factory.simple;

/**
 * @author LongyunBian
 * @version 2023/9/4 10:23
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
