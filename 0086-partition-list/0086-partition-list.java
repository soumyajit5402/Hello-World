class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0), smallerHead = smaller, greater = new ListNode(0), greaterHead = greater, curr = head;
        while (curr != null) {
            if (curr.val < x) {
                smaller.next = curr;
                curr = curr.next;
                smaller = smaller.next;
                smaller.next = null;
            } else {
                greater.next = curr;
                curr = curr.next;
                greater = greater.next;
                greater.next = null;
            }   
        }
        smaller.next = greaterHead.next;
        return smallerHead.next;
    }
}