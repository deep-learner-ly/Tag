package basics.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LongyunBian
 * @version 2023/9/26 10:19
 */
public class 交替打印ABC三 {
    private static final int ITERATIONS = 10000; // 控制打印的次数
    private static final Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static  char currentLetter = 'A'; // 当前应该打印的字母
    private static  int i = 1;
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> printLetter('A', 'B',conditionA, conditionB));
        Thread threadB = new Thread(() -> printLetter('B','C',  conditionB, conditionC));
        Thread threadC = new Thread(() -> printLetter('C','A', conditionC, conditionA));
        threadA.start();
        threadB.start();
        threadC.start();

    }
    private static void printLetter(char letter, char next,Condition currentCondition, Condition nextCondition) {
        for (; i < ITERATIONS; i++) {
            lock.lock();
            try {
                while (currentLetter != letter) {
                    currentCondition.await();
                }
                if(i>ITERATIONS){
                    break;
                }
                System.out.println(i);
                System.out.println(letter);
                currentLetter = next;
                nextCondition.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }
}
