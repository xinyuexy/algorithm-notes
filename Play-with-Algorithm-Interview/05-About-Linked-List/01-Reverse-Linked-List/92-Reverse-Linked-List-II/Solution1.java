//leetcode 92. Reverse Linked List II
private class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy.next;
        for(int i=0; i<n; i++) {
            if(i < m-1) {
                pre = pre.next; //find m-1 node
            }
            end = end.next; //find n+1 node
        }
        
        ListNode rhead = reverse(pre.next, end);
        pre.next = rhead;

        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = end;
        ListNode cur = start;
        while(cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}