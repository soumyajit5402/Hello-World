class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (target < nums[left]) return 0;
        if (target > nums[right]) return nums.length;
        
        while (right - left > 1) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (nums[left] == target) return left;
        return nums[left] > target ? left : right;
    }
}