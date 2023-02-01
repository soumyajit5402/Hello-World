class Solution {
    public boolean canJump(int[] nums) {
        int closestPossibleIndex = nums.length - 1;
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (closestPossibleIndex <= i + nums[i]) {
                closestPossibleIndex = i;
            }
            // for (int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); j++) {
            //     if (dp[j]) {
            //         dp[i] = true;
            //         break;
            //     }
            // }
        }
        return closestPossibleIndex == 0;
    }
}