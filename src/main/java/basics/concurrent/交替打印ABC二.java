package basics.concurrent;

/**
 * @author LongyunBian
 * @version 2023/9/9 17:58
 */
public class 交替打印ABC二 {


    private static final Object lock = new Object();
    private static volatile int count = 0;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 == 0) {
                        System.out.print("A");
                        count++;
                        lock.notifyAll();
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 == 1) {
                        System.out.print("B");
                        count++;
                        lock.notifyAll();
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 == 2) {
                        System.out.print("C");
                        count++;
                        lock.notifyAll();
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        threadB.start();
        threadC.start();
        threadA.start();

    }


}
