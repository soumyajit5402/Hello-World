class Solution {
    public int rob(int[] nums) {
        int[] robbedValDP = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            robbedValDP[i] = nums[i];
            if (i >= 2) robbedValDP[i] += robbedValDP[i-2];
            if (i >= 1 && robbedValDP[i-1] > robbedValDP[i]) robbedValDP[i] = robbedValDP[i-1];
        }
        return robbedValDP[nums.length - 1];
    }
}