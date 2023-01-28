class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val) return mergeTwoLists(list2, list1);
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
}