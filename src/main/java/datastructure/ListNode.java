package datastructure;

/**
 * @author: LongyunBian
 * @date: 2023/8/18 22:43
 * @Description: 链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
