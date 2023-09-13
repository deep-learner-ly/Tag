package example;

import java.util.HashMap;

/**
 * @author LongyunBian
 * @version 2023/9/13 10:48
 */
public class LRUCache {
    int size;
    int cap;
    Node head;
    Node tail;
    HashMap<Integer,Node> map;

    static class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }

    public LRUCache(int cap) {
        this.cap = cap;
        size=0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    private boolean isEmpty(){
        return size==0;
    }
    private boolean isFull(){
        return size==cap;
    }
    public int get(int key){
        if(isEmpty()){
            return -1;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            int val = node.val;
            remove(node);
            addFirst(node);
            return val;
        }
        return -1;
    }
    public void put(int key, int val){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = val;
            remove(node);
            addFirst(node);
            return;
        }
        if(isFull()){
            Node last = removeLast();
            map.remove(last.key);
        }else{
            size++;
        }
        Node node = new Node();
        node.key = key;
        node.val = val;
        map.put(key,node);
        addFirst(node);
    }

    private Node removeLast() {
        Node last = tail.prev;
        remove(last);
        return last;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addFirst(Node node){
        Node first = head.next;
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 返回 1
        cache.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2)); // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1)); // 返回 -1 (未找到)
        System.out.println(cache.get(3)); // 返回 3
        System.out.println(cache.get(4)); // 返回 4
    }
}
