class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> averages = new HashSet<>();
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            averages.add(nums[i] + nums[j]);
        }
        return averages.size();
    }
}