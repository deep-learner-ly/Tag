package algorithm.linkedlist;

import datastructure.ListNode;
import utils.Utils;

/**
 * @author LongyunBian
 * @version 2023/9/20 15:02
 */
public class 重排链表 {
    public void reorderList(ListNode head) {
        ListNode end = Utils.endOfHalfLinkedList(head);
        ListNode part2 = end.next;
        end.next = null;
        ListNode newHead = Utils.reverse(part2);
        while (head!=null){
            ListNode nxt1 =  head.next;
            ListNode nxt2 = newHead.next;
            head.next = newHead;
            if(nxt1!=null){
                newHead.next = nxt1;
            }
            head = nxt1;
            newHead = nxt2;
        }
    }
    public void reorderListMerge(ListNode head) {
        ListNode end = Utils.endOfHalfLinkedList(head);
        ListNode part2 = end.next;
        end.next = null;
        ListNode newHead = Utils.reverse(part2);
        new 合并两个链表().mergeList(head,newHead);
    }
}
