package basics.error;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/9/12 17:04
 */
public class 堆OOM例子 {
    public static void main(String[] args) {
        //  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        //	at basics.error.堆OOM例子.main(堆OOM例子.java:14)
        List<byte[]> list = new ArrayList<>();
        while (true) {
            byte[] data = new byte[1024 * 1024]; // 每次分配1MB的内存
            list.add(data);
        }

    }
}
