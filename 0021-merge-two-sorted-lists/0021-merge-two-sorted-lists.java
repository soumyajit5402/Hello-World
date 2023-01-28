class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        if (list1.val > list2.val) return mergeTwoLists(list2, list1);
        
        ListNode head = list1;
        ListNode temp = list1.next;
        list1.next = list2;
        list1 = temp;
        head.next = mergeTwoLists(list1, list2);
        return head;
    }
}