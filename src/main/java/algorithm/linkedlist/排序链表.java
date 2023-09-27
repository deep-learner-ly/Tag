package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/3 22:24
 */
public class 排序链表 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode fast = head, slow = head, pre = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return new 合并两个有序链表().mergeList(sortList(head),sortList(slow));
    }


}
