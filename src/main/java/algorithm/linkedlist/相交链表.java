package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/19 9:19
 */
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1!=p2){
            p1 = p1==null?headB: p1.next;
            p2 = p2==null? headA:p2.next;
        }
        return p1;
    }
}
