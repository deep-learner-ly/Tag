package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/5 9:40
 */
public class 删除排序链表中的重复元素II {
    /**
     *
     *几乎所有的链表题目，都具有相似的解题思路。
     *
     * 建一个「虚拟头节点」dummy 以减少边界判断，
     * 往后的答案链表会接在 dummy 后面
     *
     * 使用 tail 代表当前有效链表的结尾
     *
     * 通过原输入的 head 指针进行链表扫描
     *
     * 我们会确保「进入外层循环时 head 不会与上一节点相同」，因此插入时机：
     *
     * head 已经没有下一个节点，head 可以被插入
     *
     * head 有一下个节点，但是值与 head 不相同，head 可以被插入
     *
     */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head != null) {

            // 进入循环时，确保了 head 不会与上一 节点相同
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            // 如果 head 与下一 节点相同，跳过相同节点
            while (head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;

        }
        tail.next = null;
        return dummy.next;
    }
}
