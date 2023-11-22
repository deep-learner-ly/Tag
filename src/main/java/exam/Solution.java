package exam;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/10/19 9:05
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head0 = new ListNode(0);

        ListNode head = new ListNode(1);
        head0.next = head;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new Solution().kGroupReverse(head0, 4);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    public ListNode kGroupReverse(ListNode head,int k){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = head, end =head;
        ListNode pre = dummy;
        ListNode next = null;
        while (end!=null){
            for (int i = 0; i < k-1&&end!=null; i++) {

                end=end.next;
            }
            if(end==null){
                break;
            }
//            System.out.println(end.val);
            next = end.next;
            end.next =null;
            pre.next =  reverse(start);
            start.next = next;
            pre = start;
            start = pre.next;
            end = pre.next;


        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode newHead = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
