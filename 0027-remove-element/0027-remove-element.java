class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == val) nums[right++] = Integer.MIN_VALUE;
            else nums[left++] = nums[right++];
        }
        return left;
    }
}