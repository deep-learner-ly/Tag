package designpattern.proxy.jdkdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
/**
 * @author LongyunBian
 * @version 2023/9/15 15:22
 */
@Slf4j
public class AnimalHandler implements InvocationHandler {
    private final Animal animal;
    public AnimalHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            //前置通知
            before();
            System.out.println("before");
//            System.out.println(method.getName());
            result = method.invoke(animal, args);
            //后置通知
            after();
            System.out.println("after");
        } catch (Exception e) {
            //异常通知
            exception();
        } finally {
            //方法返回前通知
            beforeReturning();
        }

        return result;
    }
    private void before() {
        log.info("before method invoke...");
    }

    private void after() {
        log.info("after method invoke...");
    }

    private void exception() {
        log.info("exception method invoke...");
    }

    private void beforeReturning() {
        log.info("beforeReturning method invoke...");
    }


}
