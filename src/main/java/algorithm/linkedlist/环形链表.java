package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/5 11:06
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;

    }

}
