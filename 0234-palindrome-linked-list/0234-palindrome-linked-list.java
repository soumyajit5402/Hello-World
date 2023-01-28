class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        Stack<Integer> container = new Stack<>();
        ListNode slow = head, fast = head;
        boolean lengthOdd = false;
        
        while (fast != null) {
            container.push(slow.val);
            
            slow = slow.next;
            fast = fast.next;
            
            if (fast != null) fast = fast.next;
            else lengthOdd = true;
        }
        
        if (lengthOdd) container.pop();
        
        while (slow != null) {
            if (slow.val != container.pop()) return false;
            slow = slow.next;
        }
        return true;
    }
}