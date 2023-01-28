class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> container = new ArrayList<>();
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int currSum = nums[i] + nums[j] + nums[k]; 
                if (currSum == 0) {
                    List<Integer> curr = new ArrayList<>();
                    container.add(curr);
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    j++;
                    k--;
                } else if (currSum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return container;
    }
}