package designpattern.factory.simple;

/**
 * @author LongyunBian
 * @version 2023/9/4 10:26
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
