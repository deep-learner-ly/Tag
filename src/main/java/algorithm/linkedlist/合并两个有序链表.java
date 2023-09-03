package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/3 22:06
 */
public class 合并两个有序链表 {
    public ListNode mergeList(ListNode nodea, ListNode nodeb) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(nodea != null && nodeb != null){
            if(nodea.val < nodeb.val){
                cur.next = nodea;
                nodea = nodea.next;
            }else{
                cur.next = nodeb;
                nodeb = nodeb.next;
            }
            cur = cur.next;
        }
        cur.next = nodea!=null?nodea:nodeb;

        return dummy.next;
    }
}
