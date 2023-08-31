package designpattern.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LongyunBian
 * @version 2023/8/31 21:21
 */
public class MessageQueue {
    private int bufferSize;
    private int size;
    private Queue<String> queue;
    public MessageQueue(int bufferSize){
        this.bufferSize = bufferSize;
        size = 0;
        queue = new LinkedList<>();
    }
    public synchronized void enqueue(String message) throws InterruptedException {
        if(isFull()){
            System.out.println("队满");
            wait();
        }
        queue.offer(message);
        size++;
        notifyAll();

    }
    public synchronized String dequeue() throws InterruptedException {
        if(isEmpty()){
            System.out.println("队空");
            wait();
        }
        String message = queue.poll();
        size--;
        notifyAll();
        return message;
    }
    private boolean isEmpty(){
        return size==0;
    }
    private boolean isFull(){
        return size==bufferSize;
    }

    public static void main(String[] args) {
        MessageQueue mq = new MessageQueue(10);
        Thread producer =  new Thread(()->{
            while (true){
                String msg = "msg";
                try {
                    mq.enqueue(msg);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });


         Thread consumer = new Thread(()->{
            while (true){
                try {
                    String msg = mq.dequeue();
                    System.out.println(msg + "is consumed");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
         producer.start();
         consumer.start();
    }

}
