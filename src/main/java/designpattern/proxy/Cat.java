package designpattern.proxy;

/**
 * @author LongyunBian
 * @version 2023/9/15 15:21
 */
public class Cat implements Animal{
    @Override
    public void doWhat(boolean isDo) throws Exception {
        if (!isDo) {
            System.out.println("Cat只会吃！");
            throw new Exception("Cat只会吃");
        } else {
            System.out.println("Cat会喵喵喵");
        }
    }
}
