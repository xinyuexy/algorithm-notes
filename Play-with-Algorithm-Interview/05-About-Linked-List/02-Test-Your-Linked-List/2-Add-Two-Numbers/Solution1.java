//leetcode 2. Add Two Numbers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null && l2 != null) {
            int val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            int val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            int val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l2 = l2.next;
        }
        if(carry > 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }
}