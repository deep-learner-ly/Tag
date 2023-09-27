package algorithm.linkedlist;

import datastructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class 排序链表Test {

    @Test
    public void sortList() {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5)))));
        ListNode sortedHead = new 排序链表().sortList(head);
        assertEquals(1, sortedHead.val);
        assertEquals(2, sortedHead.next.val);
        assertEquals(3, sortedHead.next.next.val);
        assertEquals(4, sortedHead.next.next.next.val);
        assertEquals(5, sortedHead.next.next.next.next.val);
    }
}