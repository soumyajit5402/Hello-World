class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) nums[right++] = Integer.MIN_VALUE;
            else nums[++left] = nums[right++];
        }
        return left + 1;
    }
}