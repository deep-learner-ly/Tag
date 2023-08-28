package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/8/21 14:10
 * @link https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class K个一组翻转链表 {
    public static void main(String[] args) {
        K个一组翻转链表 test = new K个一组翻转链表();
        int [] array = {1,2,3,4,5};
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i : array) {
            cur.next =  new ListNode(i);
            cur = cur.next;
        }
        ListNode listNode = test.reverseKGroup(dummy.next, 2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;

            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;

            pre.next = 反转链表.reverseList(start);
            start.next = next;

            pre = start;
            end = start;
        }
        return dummy.next;
    }
}
