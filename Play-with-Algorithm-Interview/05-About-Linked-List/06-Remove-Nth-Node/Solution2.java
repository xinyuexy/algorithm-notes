//只遍历一遍

//leetcode 19. Remove Nth Node From End of List
//遍历两遍链表
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 1) {
            return null;
        }
        if(head.next == null && n == 1) {
            return null;
        }

        //双指针(要删除的结点和最后null结点的距离是固定的)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;

        int i = 0;
        while(q != null) {
            if(i < n+1) {
                q = q.next;
                i++;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        p.next = p.next.next;
        return dummy.next;
    }
}