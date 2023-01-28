class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((long)nums[i] - (long)nums[i-1] > 1l) {
                if (i-1 == start) ans.add("" + nums[i-1]);
                else ans.add(nums[start] + "->" + nums[i-1]);
                start = i;
            }
        }
        
        if (nums.length - 1 == start) ans.add("" + nums[start]);
        else ans.add(nums[start] + "->" + nums[nums.length - 1]);
        
        return ans;
    }
}