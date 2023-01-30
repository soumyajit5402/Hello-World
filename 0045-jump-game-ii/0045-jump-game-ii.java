class Solution {
    public int jump(int[] nums) {
        int[] dp_ans = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(nums.length - 1, i + nums[i]); j++) {
                if (dp_ans[j] >= 0) {
                    min = Math.min(min, dp_ans[j] + 1);   
                    if (min == 1) break;
                }
            }
            dp_ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp_ans[0];
    }
}