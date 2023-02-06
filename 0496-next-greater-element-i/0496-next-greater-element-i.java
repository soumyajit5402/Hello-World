class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> container = new HashMap<>();
        int[] nextGreaterIndex = new int[nums2.length];
        Stack<Integer> nextGreater = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            container.put(nums2[i], i);
            while (!nextGreater.isEmpty() && nums2[i] > nums2[nextGreater.peek()]) {
                nextGreaterIndex[nextGreater.pop()] = nums2[i];
            }
            nextGreater.push(i);
        }
        while (!nextGreater.isEmpty()) {
            nextGreaterIndex[nextGreater.pop()] = -1;
        }
        
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index2 = container.get(nums1[i]);
            ans[i] = nextGreaterIndex[index2];
        }
        return ans;
    }
}