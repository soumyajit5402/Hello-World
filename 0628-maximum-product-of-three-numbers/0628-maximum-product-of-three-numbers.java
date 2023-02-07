class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int optn1 = nums[0] * nums[1] * nums[nums.length - 1];
        int optn2 = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        return Math.max(optn1, optn2);
    }
}