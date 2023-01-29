class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { findMinIndex(nums, target), findMaxIndex(nums, target) };
    }
    
    int findMinIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        
        if (nums.length == 0) return -1;
        else if (nums[left] == target) return left;
        else if (nums[right] == target) return right;
        else return -1;
    }
    
    int findMaxIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        
        if (nums.length == 0) return -1;
        else if (nums[right] == target) return right;
        else if (nums[left] == target) return left;
        else return -1;
    }
}