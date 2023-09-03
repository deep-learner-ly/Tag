package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/3 22:24
 */
public class 排序链表 {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        // find mid
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return new 合并两个有序链表().mergeList(sortList(head), sortList(slow));
    }
}
