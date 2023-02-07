class Solution {
    int[][] dp;
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        dp = new int[nums.length][2 * total + 1];
        for (int[] arr : dp) Arrays.fill(arr, Integer.MIN_VALUE);
        return computeWays(nums, 0, 0, target);
    }
    
    private int computeWays(int[] arr, int i, int sum, int target) {
        if (i == arr.length && sum == target) return 1;
        if (i == arr.length) return 0;
        if (dp[i][total + sum] == Integer.MIN_VALUE) {
            int countWith = computeWays(arr, i + 1, sum + arr[i], target);
            int countWithout = computeWays(arr, i + 1, sum - arr[i], target);
            dp[i][total + sum] = countWith + countWithout;    
        }
        return dp[i][total + sum];
    }
}