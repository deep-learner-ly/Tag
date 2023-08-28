package datastructure;

/**
 * @author LongyunBian
 * @version 2023/8/22 10:23
 */
import java.util.LinkedList;
import java.util.Random;

public class SimpleMessageQueue {
    private final LinkedList<String> queue;
    private final int capacity;

    public SimpleMessageQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized void enqueue(String message) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("消息队列满，等待被消费");
            wait();
        }
        queue.addLast(message);
        notifyAll();
    }

    public synchronized String dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("消息队列空，等待生产");
            wait();
        }
        String message = queue.removeFirst();
        notifyAll();
        return message;
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        SimpleMessageQueue messageQueue = new SimpleMessageQueue(10);
        Random random = new Random();
        // Producer
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    String message = "Message " + i;
                    messageQueue.enqueue(message);
                    System.out.println("Enqueued: " + message);
                    int waitTime = 100 + random.nextInt(1000);
                    Thread.sleep(waitTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer
        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    String message = messageQueue.dequeue();
                    System.out.println("Dequeued: " + message);
                    int waitTime = 500 + random.nextInt(1000);
                    Thread.sleep(waitTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
