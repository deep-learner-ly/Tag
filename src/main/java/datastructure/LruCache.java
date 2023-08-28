package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LongyunBian
 * @version  2023/8/18 22:48
 */
public class LruCache {
    int size;
    int capacity;
    BiListNode head;
    BiListNode tail;
    Map<Integer, BiListNode> map;

    /**
     * 构造 LruCache 对象。
     *
     * @param capacity 缓存的最大容量
     */
    public LruCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new BiListNode();
        tail = new BiListNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    /**
     * 获取缓存中指定 key 对应的值。
     *
     * @param key 要查找的 key
     * @return key 对应的值，如果不存在则返回 -1
     */
    public int get(int key) {
        if (isEmpty()) {
            return -1;
        }
        if (map.containsKey(key)) {
            BiListNode node = map.get(key);
            remove(node);
            addFirst(node);
            return node.val;
        }
        return -1;
    }

    /**
     * 向缓存中放入指定的 key 和 value。
     *
     * @param key 要放入的 key
     * @param val 要放入的 value
     */
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            BiListNode node = map.get(key);
            node.val = val;
            remove(node);
            addFirst(node);
            return;
        }
        if (isFull()) {
            BiListNode last = removeLast();
            map.remove(last.key);
        } else {
            size++;
        }
        BiListNode node = new BiListNode(key,val);
        map.put(key, node);
        addFirst(node);
    }

    /**
     * 判断缓存是否为空。
     *
     * @return 缓存是否为空的布尔值
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断缓存是否已满。
     *
     * @return 缓存是否已满的布尔值
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * 移除最近最少使用的节点。
     *
     * @return 被移除的节点
     */
    public BiListNode removeLast() {
        BiListNode last = tail.prev;
        remove(last);
        return last;
    }

    /**
     * 在链表头部添加节点。
     *
     * @param node 要添加的节点
     */
    private void addFirst(BiListNode node) {
        BiListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    /**
     * 从链表中移除节点。
     *
     * @param node 要移除的节点
     */
    private void remove(BiListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

