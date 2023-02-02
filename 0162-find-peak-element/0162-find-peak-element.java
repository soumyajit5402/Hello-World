class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            boolean isLeftGreater = false;
            if (mid > 0 && nums[mid-1] > nums[mid]) isLeftGreater = true;
            
            boolean isRightGreater = false;
            if (mid < nums.length-1 && nums[mid+1] > nums[mid]) isRightGreater = true;
            
            // m-1 > m > m+1 -> peak on right side
            // m-1 < m < m+1 -> peak on left side
            // m-1 < m > m+1 -> peak found
            // m-1 > m < m+1 -> peak on either side
            
            if (!isLeftGreater && !isRightGreater) return mid;
            else if (isLeftGreater) right = mid-1; // if left element is greater, it could be a potential peak
            else left = mid+1; // if right element is greater, it could be a potential peak
        }
        return left;
    }
}