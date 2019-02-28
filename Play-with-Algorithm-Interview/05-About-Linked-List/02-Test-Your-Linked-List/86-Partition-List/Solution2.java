//Solution2: 每次将比x小的删除后放到前面
class Solution1 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        ListNode cur = pre;

        while(cur.next != null) {
            if(cur.next.val < x) {
                //从当前位置中删除
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                //插入到前面
                tmp.next = pre.next;
                pre.next = tmp;
                pre = tmp;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}