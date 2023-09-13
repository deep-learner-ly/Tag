package basics.concurrent;

/**
 * @author LongyunBian
 * @version 2023/9/9 17:51
 */
public class 交替打印ABC {

    private static final Object lock = new Object();
    private static volatile int count = 0;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    count++;
                    lock.notifyAll();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    count++;
                    lock.notifyAll();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (count % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    count++;
                    lock.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }


}
