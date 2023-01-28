class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        long targetL = target;
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans; // handle edge case
        for (int i = 0; i <= nums.length - 4; i++) {
            // avoid duplicates
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j <= nums.length - 3; j++) {
                // avoid duplicates
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int a = j + 1;
                int b = nums.length - 1;
                long newTargetL = targetL - nums[i] - nums[j];
                
                while (a < b) {
                    long currState = newTargetL - nums[a] - nums[b];
                    if (currState == 0) {
                        ans.add(Arrays.asList( nums[i], nums[j], nums[a], nums[b]));
                        a++;
                        b--;
                        while (nums[a] == nums[a-1] && a < b) {
                            a++;
                        }
                    } else if (currState > 0) {
                        a++;
                    } else {
                        b--;
                    }
                }
            }
        }
        
        return ans;
    }
}