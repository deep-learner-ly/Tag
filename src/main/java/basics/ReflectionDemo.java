package basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author LongyunBian
 * @version 2023/8/19 0:04
 */
public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class<?> ListNodeClass = Class.forName("datastructure.ListNode");
            Constructor<?> constructor = ListNodeClass.getConstructor(int.class);
            Object o = constructor.newInstance(0);
            System.out.println(o.toString());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
