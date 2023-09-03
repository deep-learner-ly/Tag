package algorithm.linkedlist;

import datastructure.ListNode;

/**
 * @author LongyunBian
 * @version 2023/9/3 22:07
 */
public class 合并K个有序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        return mergeKLists(lists, 0, lists.length-1);
    }
    private ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start==end){
            return lists[start];
        }else if(start<end){
            int mid = start + (end-start)/2;
            ListNode left = mergeKLists(lists, start,mid);
            ListNode right = mergeKLists(lists, mid+1,end);
            return new 合并两个有序链表().mergeList(left, right);
        }else{
            return null;
        }
    }
}
