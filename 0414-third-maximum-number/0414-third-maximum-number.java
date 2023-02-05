class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 0, index = nums.length - 1;
        while (count < 2 && --index >= 0) {
            count += (nums[index] < nums[index + 1]) ? 1 : 0;
        }
        return count == 2 ? nums[index] : nums[nums.length - 1];
    }
}