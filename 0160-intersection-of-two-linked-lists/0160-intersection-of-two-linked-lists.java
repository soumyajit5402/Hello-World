public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> container = new HashSet<>();
        while (headA != null) {
            container.add(headA);
            headA = headA.next;
        }
        
        while (headB != null) {
            if (container.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}