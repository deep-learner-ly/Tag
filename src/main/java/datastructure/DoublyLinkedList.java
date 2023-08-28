package datastructure;

/**
 * @author LongyunBian
 * @version 2023/8/21 12:16
 */
public class DoublyLinkedList {
    BiListNode head, tail;
    int size;

    DoublyLinkedList() {
        head = new BiListNode();
        tail = new BiListNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(BiListNode node) {
        BiListNode prevHead = head.next;
        node.prev = head;
        head.next = node;
        node.next = prevHead;
        prevHead.prev = node;
        size++;
    }

    public void remove(BiListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public BiListNode getHead() {
        return head.next;
    }

    public BiListNode getTail() {
        return tail.prev;
    }


}
