class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (right - left > 1) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < nums[left]) { 
                if (target <= nums[right] && target > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }
        }
        
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}