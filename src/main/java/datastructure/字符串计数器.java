package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LongyunBian
 * @version 2023/9/16 0:41
 */
public class 字符串计数器 {
    // todo
    Node head, tail;
    Map<String, Node> map;

    static class Node {
        String key;
        int val;
        Node prev;
        Node next;
    }

    public 字符串计数器() {
        map = new HashMap<>();
        head = new Node();
        head.val = Integer.MAX_VALUE;
        tail = new Node();
        head.next = tail;
        tail.prev = head;

    }
    private boolean isEmpty(){
        return map.size()==0;
    }

    public void inc(String key) {
        if(map.containsKey(key)){
//            System.out.println(key);
//            System.out.println(map.get(key).key);
            Node node = map.get(key);
            node.val++;
            Node pre = node.prev;
            if(node.val> pre.val){
                swap(node,pre);
            }
            return;
        }
        Node node = new Node();
        node.key = key;
        node.val = 1;
        map.put(key,node);
        addLast(node);
    }
    public void dec(String key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val--;
            if(node.val==0){
                remove(node);
                map.remove(key);
                return;
            }
            Node nxt = node.next;
            if(node.val<nxt.val){
                swap(node,nxt);
            }
        }

    }

    private void addLast(Node node) {
        Node last = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = last;
        last.next = node;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // 双向链表交换相邻两个节点
    private void swap(Node node ,Node nxt){
        // 不进行值交换，进行结点交换
        Node pre = node.prev;
        Node next = nxt.next;
        pre.next = nxt;
        nxt.prev = pre;
        next.prev = nxt;
        nxt.next = next;

    }




    public String getMaxKey() {
        if(isEmpty()){
            return null;
        }
        return head.next.key;
    }

    public String getMinKey() {
        if(isEmpty()){
            return null;
        }
        return tail.prev.key;

    }

    public static void main(String[] args) {
        字符串计数器 obj = new 字符串计数器();
        obj.inc("hello");  // "hello" 的值为1
        obj.inc("goodbye");  // "goodbye" 的值为1
        obj.inc("hello");  // "hello" 的值为2
        obj.inc("hello");  // "hello" 的值为3
        System.out.println(obj.getMaxKey());  // 返回链表中的第一个键，即 "hello"
        obj.inc("leet");  // "leet" 的值为1
        obj.inc("code");  // "code" 的值为1
        obj.inc("leet") ; // "leet" 的值为2
        obj.dec("hello");  // "hello" 的值减少到2
        obj.inc("leet");  // "leet" 的值为3
        obj.inc("code");  // "code" 的值为2
        obj.inc("code");  // "code" 的值为3
        System.out.println(obj.getMaxKey());  // 返回链表中的第一个键，即 "leet"
    }
}
