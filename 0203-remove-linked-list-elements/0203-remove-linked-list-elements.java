class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = head;
        ListNode curr = head == null ? null : head.next;
        
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next; 
            else prev = curr;
            curr = curr.next;
        }
        
        if (head != null && head.val == val) return head.next;
        return head;
    }
}