class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        computeWays(nums, 0, 0, target);
        return count;
    }
    
    private void computeWays(int[] arr, int i, int sum, int target) {
        if (i == arr.length && sum == target) count++;
        if (i == arr.length) return;
        computeWays(arr, i + 1, sum + arr[i], target);
        computeWays(arr, i + 1, sum - arr[i], target);
    }
}