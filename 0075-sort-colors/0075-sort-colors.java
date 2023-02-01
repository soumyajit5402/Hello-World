class Solution {
    public void sortColors(int[] nums) {
        int oneCount = 0, twoCount = 0;
        for (int num : nums) {
            if (num == 1) oneCount++;
            if (num == 2) twoCount++;
        }
        
        Arrays.fill(nums, 0);
        int index = nums.length - oneCount - twoCount, end = index + oneCount;
        for (; index < end; index++) nums[index] = 1;
        for (; index < nums.length; index++) nums[index] = 2;
    }
}