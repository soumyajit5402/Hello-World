class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        Set<Integer> duplicates = new HashSet<>();
        ListNode prev = head, curr = head.next;
        while (curr != null) {
            if (prev.val == curr.val) duplicates.add(curr.val);
            prev = curr;
            curr = curr.next;
        }
        
        prev = head;
        curr = head.next;
        while (curr != null) {
            if (duplicates.contains(curr.val)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        if (duplicates.contains(head.val)) return head.next;
        return head;
    }
}