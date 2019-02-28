//leetcode 83. Remove Duplicates from Sorted List
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
        
        ListNode p = head, q = head.next;
        while(q != null) {
            while(q != null && q.val == p.val) {
                q = q.next;
            }
            p.next = q;
            if(q == null) break;
            p = q;
            q = q.next;
        }
        return head;
    }
}