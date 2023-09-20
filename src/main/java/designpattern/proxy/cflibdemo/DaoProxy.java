package designpattern.proxy.cflibdemo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author LongyunBian
 * @version 2023/9/19 23:57
 */
public class DaoProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before Method Invoke");
        methodProxy.invokeSuper(o, objects);
        System.out.println("After Method Invoke");
        return o;
    }
}
