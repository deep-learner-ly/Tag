package designpattern.proxy.jdkdemo;

import java.lang.reflect.Proxy;

/**
 * @author LongyunBian
 * @version 2023/9/15 15:45
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Animal cat = new Cat();
        /**
         * loader: 用哪个类加载器去加载代理对象
         * interfaces:动态代理类需要实现的接口
         * h:动态代理方法在执行时，会调用h里面的invoke方法去执行
         */
        Animal animal = (Animal) Proxy.newProxyInstance(cat.getClass().getClassLoader(), Cat.class.getInterfaces(), new AnimalHandler(cat));
        animal.doWhat(true);
        //animal.doWhat(false);
    }
}
