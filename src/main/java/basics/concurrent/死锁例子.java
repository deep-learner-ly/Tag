package basics.concurrent;

/**
 * @author LongyunBian
 * @version 2023/9/17 21:40
 */
public class 死锁例子 {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
           synchronized (resource1){
               System.out.println(Thread.currentThread()+"get "+ resource1.toString());
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println(Thread.currentThread()+"waiting "+ resource2.toString());
               synchronized (resource2){
                   System.out.println(Thread.currentThread()+"get "+ resource2.toString());
               }
           }
        }).start();
        new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread()+"get "+ resource2.toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread()+"waiting "+ resource1.toString());
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"get "+ resource1.toString());
                }
            }
        }).start();

    }

}
