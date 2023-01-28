class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiffPos = Integer.MAX_VALUE, minDiffNeg = Integer.MAX_VALUE;
        
        for (int i = 0; i <= nums.length - 3; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int currSum = nums[i] + nums[j] + nums[k];
                if (currSum == target) {
                    return target;
                } else if (currSum > target) {
                    minDiffPos = Math.min(minDiffPos, currSum - target);
                    k--;
                } else {
                    minDiffNeg = Math.min(minDiffNeg, target - currSum);
                    j++;
                }
            }
        }
        
        if (minDiffPos < minDiffNeg) return target + minDiffPos;
        else return target - minDiffNeg;
    }
}