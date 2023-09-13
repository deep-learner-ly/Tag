package basics.error;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * @author LongyunBian
 * @version 2023/9/12 16:20
 */
public class 元空间OOM例子 {
    public static void main(String[] args) {
        /**
         * Caused by: java.lang.OutOfMemoryError: Metaspace
         * 	at java.lang.ClassLoader.defineClass1(Native Method)
         * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:756)
         * 	... 8 more
         * */
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method,
                                        Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject {
    }

}