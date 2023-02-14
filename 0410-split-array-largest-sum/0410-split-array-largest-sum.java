class Solution {
    public int splitArray(int[] nums, int k) {
        if (nums.length < k) return -1;
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (isPossiblePartition(nums, k, mid)) right = mid;
            else left = mid + 1;
        }
        if (isPossiblePartition(nums, k, left)) return left;
        if (isPossiblePartition(nums, k, right)) return right;
        return -1;
    }
    
    private boolean isPossiblePartition(int[] arr, int parts, int maxSubArrSum) {
        int partCount = 1;
        int currSum = 0;
        for (int num : arr) {
            currSum += num;
            if (currSum > maxSubArrSum) {
                partCount++;
                currSum = num;
            }
        }
        return partCount <= parts;
    }
}