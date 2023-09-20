package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/20 16:11
 */
public class 合并两个链表 {
    public void mergeList(ListNode head, ListNode _head){

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        boolean flag = true;
        while(head!=null && _head!=null){
            if(flag){
                cur.next = head;
                head= head.next;
            }else{
                cur.next = _head;
                _head= _head.next;
            }

            cur = cur.next;
            flag = !flag;

        }
        cur.next = _head;

    }
}
