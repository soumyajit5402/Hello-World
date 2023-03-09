class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int total = nums[0];
        int[] prefSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            prefSum[i] = nums[i - 1] + prefSum[i - 1];
            total += nums[i];
        }
        
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(prefSum[i] - (total - prefSum[i] - nums[i]));
        }
        return ans;
    }
}