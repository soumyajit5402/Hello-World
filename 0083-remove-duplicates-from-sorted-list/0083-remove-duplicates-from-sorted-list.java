class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode left = head, right = head.next;
        while (right != null) {
            if (left.val == right.val) left.next = right.next;
            else left = left.next;
            right = right.next;
        }
        return head;
    }
}