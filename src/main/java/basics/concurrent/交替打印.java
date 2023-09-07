package basics.concurrent;

/**
 * @author LongyunBian
 * @version 2023/9/6 16:12
 */
public class 交替打印 {
    private static  int num = 1;
    private static final int MAX_NUM = 100;
    private static final Object lock= new Object();
    public static void main(String[] args) {
        Thread oddThread = new Thread(()->{
            while (num<=MAX_NUM){
                synchronized (lock){
                    if(num % 2 ==1){
                        System.out.println("奇数："+ num);
                        num++;
                        lock.notify();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        });

        Thread evenThread = new Thread(()->{
            while (num<=MAX_NUM){
                synchronized (lock){
                    if(num % 2 ==0){
                        System.out.println("偶数："+ num);
                        num++;
                        lock.notify();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        });
        oddThread.start();
        evenThread.start();
    }
}
