package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/5 9:58
 */
public class 删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(101);
        ListNode tail = dummy;
        while (head != null) {

            tail.next = head;
            tail = head;
            // 如果 head 与下一节点相同，跳过相同节点
            while (head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;

        }
        tail.next = null;
        return dummy.next;
    }
}
