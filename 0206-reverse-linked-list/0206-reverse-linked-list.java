class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = null, next = head;
        while (next != null) {
            ListNode tempNext = next.next;
            next.next = curr;
            curr = next;
            next = tempNext;
        }
        return curr;
    }
}