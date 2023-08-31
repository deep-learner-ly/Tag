package designpattern.template;

/**
 * @author LongyunBian
 * @version 2023/9/1 0:22
 */
public abstract class AbstractClass {
    public final void templateMethod() {
        //...
        method1();
        //...
        method2();
        //...
    }

    protected abstract void method1();
    protected abstract void method2();
}
