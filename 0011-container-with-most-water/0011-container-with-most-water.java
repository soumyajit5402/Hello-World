class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxVol = 0;
        while (left < right) {
            int currVol = Math.min(height[left], height[right]) * (right - left);
            maxVol = Math.max(maxVol, currVol);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxVol;
    }
}