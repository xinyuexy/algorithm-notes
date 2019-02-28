//leetcode 86. Partition List
//参考:https://leetcode.com/problems/partition-list/solution/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode left_dummy = new ListNode(0);
        ListNode right_dummy = new ListNode(0);
        //左右两个链表头结点
        ListNode left = left_dummy, right = right_dummy;

        while(head != null) {
            if(head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        //左右进行连接
        left.next = right_dummy.next;
        right.next = null;
        return left_dummy.next;
    }
}