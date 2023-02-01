class Solution {
    public int removeDuplicates(int[] nums) {
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] == nums[i-1] && nums[i] == nums[i-2]) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        
        int slow = 1, fast = 1, count = 1;
        while (fast < nums.length) {
            if (nums[fast] != Integer.MAX_VALUE) {
                nums[slow++] = nums[fast++];
                count++;
            } else {
                fast++;
            }
        }
        return count;
    }
}