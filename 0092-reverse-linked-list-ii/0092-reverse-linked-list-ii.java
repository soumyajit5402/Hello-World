class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1, mid = left + (right - left) / 2;
        Stack<ListNode> container = new Stack<>();
        ListNode tempHead = head;
        
        while (tempHead != null) {
            if (index >= left && index < mid) {
                container.push(tempHead);
            } else if (index == mid) {
                if ((right - left + 1) % 2 == 0) container.push(tempHead);
            } else if (index > mid && index <= right) {
                ListNode leftNode = container.pop();
                int tempVal = leftNode.val;
                leftNode.val = tempHead.val;
                tempHead.val = tempVal;
            }
            tempHead = tempHead.next;
            index++;
        }
        return head;
    }
}