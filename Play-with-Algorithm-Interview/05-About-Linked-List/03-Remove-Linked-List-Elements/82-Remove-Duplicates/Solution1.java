//leetcode 82. Remove Duplicates from Sorted List II
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);  
        dummy.next = head;
        ListNode pre = dummy, cur = head;

        while(cur != null && cur.next != null) {
            //怎样判断有没有重复
            if(cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}