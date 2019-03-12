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

        int len = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        while(p != null) {
            len++;
            p = p.next;
        }

        p = dummy;
        for(int i=0; i<len-n; i++) {
            p = p.next;
        }

        p.next = p.next.next;
        return dummy.next;
    }
}