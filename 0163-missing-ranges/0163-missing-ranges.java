class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int prev = lower;
        List<String> ans = new ArrayList<>();
        for (int num : nums) {
            if (num - prev == 1) ans.add("" + prev);
            else if (num != prev) ans.add("" + prev + "->" + (num - 1));
            prev = num + 1;
        }

        if (upper == prev) ans.add("" + upper);  
        else if (upper > prev) ans.add("" + prev + "->" + upper);

        return ans;
    }
}