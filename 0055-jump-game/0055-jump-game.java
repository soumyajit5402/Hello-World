class Solution {
    public boolean canJump(int[] nums) {
        // keep a track of the closest index from end where jumping is feasible
        int closestPossibleIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (closestPossibleIndex <= i + nums[i]) closestPossibleIndex = i;
        }
        return closestPossibleIndex == 0;
    }
}