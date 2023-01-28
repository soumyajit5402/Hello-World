class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode st = head, en = head;
        
        while (n-- >= 0) {
            // assuming the test case is valid, this could only happen 
            // when the head node is the n'th node from the end
            if (en == null) return head.next;
            en = en.next;
        }
        
        while (en != null) {
            st = st.next;
            en = en.next;
        }
        
        st.next = st.next.next;
        return head;
    }
}